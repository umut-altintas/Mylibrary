package UI;

import CRUD.InsertIntoDb;
import InputHandling.StringHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static CRUD.ConnectToDb.url;

public class AddBookUI extends JPanel implements ActionListener {
    JButton submit;
    JTextField nameField;
    JTextField typeField;
    JTextField languageField;
    JTextField pageNumberField;
    public AddBookUI(){
        this.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Book name:");
        JLabel typeLabel = new JLabel("Book type");
        JLabel languageLabel = new JLabel("Book language");
        JLabel pageNumberLabel = new JLabel("Page number");
        nameField = new JTextField(20);
        typeField = new JTextField(20);
        languageField = new JTextField(20);
        pageNumberField = new JTextField(20);

        submit = new JButton("Submit");
        submit.addActionListener(this);

        // Name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(nameLabel, gbc);

        // Name text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nameField, gbc);

        // Type label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(typeLabel, gbc);

        // Type text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(typeField, gbc);

        // Language label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        formPanel.add(languageLabel, gbc);

        // Language text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(languageField, gbc);

        // Page Number label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        formPanel.add(pageNumberLabel, gbc);

        // Page Number text field
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(pageNumberField, gbc);

        // Submit button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        formPanel.add(submit, gbc);

        this.add(formPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String book_name = StringHandler.Name(nameField.getText());
            String book_type = StringHandler.Name(typeField.getText());
            String book_language = StringHandler.Name(languageField.getText());
            String temp_bpn = pageNumberField.getText();
            if(book_name.isBlank()||book_type.isBlank()||book_language.isBlank()||temp_bpn.isBlank()){
                JOptionPane.showMessageDialog(this, "All field must be filled!");
            }else{
                try {
                    int book_page_number = Integer.parseInt(temp_bpn);
                    InsertIntoDb.book(url, (Integer) AuthorsTableForUI.author_id, book_name, book_type, book_language, book_page_number);
                    JOptionPane.showMessageDialog(this, book_name+" successfully added!");
                    nameField.setText("");typeField.setText("");languageField.setText("");pageNumberField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Page number must be an integer!");
                    pageNumberField.setText("");
                }
            }
        }
    }
}
