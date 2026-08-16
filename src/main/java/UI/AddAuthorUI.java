package UI;

import CRUD.InsertIntoDb;
import InputHandling.StringHandler;
import org.sqlite.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static CRUD.ConnectToDb.url;

public class AddAuthorUI extends JPanel implements ActionListener {
    JButton submit;
    JTextField nameField;
    public AddAuthorUI() {

        this.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

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

        // Submit button
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        formPanel.add(submit, gbc);

        this.add(formPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = StringHandler.Name(nameField.getText());
            InsertIntoDb.author(url, name);
        }
    }
}
