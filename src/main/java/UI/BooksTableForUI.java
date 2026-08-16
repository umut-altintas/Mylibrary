package UI;

import CRUD.ConnectToDb;

import javax.swing.*;
import java.awt.*;

public class BooksTableForUI extends JPanel{
    public BooksTableForUI(){
        this.setLayout(new BorderLayout());
        DataForUI d = new DataForUI();
        Object data = d.books(ConnectToDb.url);
        String[] columnNames = {"Author id", "Book id", "Name", "Added date", "Type", "Language", "Page number"};
        JTable table = new JTable((Object[][]) data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
