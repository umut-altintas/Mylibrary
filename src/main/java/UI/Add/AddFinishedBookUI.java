package UI.Add;

import CRUD.InsertIntoDb;
import UI.Table.FinishedBooksTableForUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static CRUD.ConnectToDb.url;
import static UI.Table.BooksTableForUI.book_id;

public class AddFinishedBookUI extends JPanel implements ActionListener {
    JTextField scoreField;
    JTextField summaryField;
    JButton submit;
    public AddFinishedBookUI(){
        this.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel scoreLabel = new JLabel("Score:");
        JLabel summaryLabel = new JLabel("Summary");
        scoreField = new JTextField(20);
        summaryField = new JTextField(20);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        // Score label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(scoreLabel, gbc);

        // Score text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(scoreField, gbc);

        // Summary label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(summaryLabel, gbc);

        // Summary text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(summaryField, gbc);


        // Submit button
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        formPanel.add(submit, gbc);

        this.add(formPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String tmp_score = scoreField.getText();
            String summary = summaryField.getText();
            if(tmp_score.isBlank()||summary.isBlank()){
                JOptionPane.showMessageDialog(this, "All fields must be filled!",
                        "Error" ,JOptionPane.PLAIN_MESSAGE);
                scoreField.setText("");
                summaryField.setText("");
            }else{
                try{
                    int score = Integer.parseInt(tmp_score);
                    if(InsertIntoDb.finishedBook(url, (Integer) book_id, score, summary)){
                        JOptionPane.showMessageDialog(this, "Congratulations",
                                "Message", JOptionPane.PLAIN_MESSAGE);
                    }
                    //Change panel
                    this.removeAll();
                    JPanel panel = new FinishedBooksTableForUI();
                    this.add(panel);
                    this.revalidate();
                    this.repaint();
                } catch (Exception NumberFormatException) {
                    JOptionPane.showMessageDialog(this, "Score must be an integer!",
                            "Error", JOptionPane.PLAIN_MESSAGE);
                    scoreField.setText("");
                }
            }
        }
    }
}
