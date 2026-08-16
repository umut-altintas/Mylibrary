package UI;

import CRUD.ConnectToDb;

import javax.swing.*;
import java.awt.*;

public class FinishedBooksTableForUI extends JPanel{
    public FinishedBooksTableForUI(){
        this.setLayout(new BorderLayout());
        DataForUI d = new DataForUI();
        Object data = d.finishedBooks(ConnectToDb.url);
        String[] columnNames = {"Book id", "Finished date", "Read time", "Score", "Summary"};
        JTable table = new JTable((Object[][]) data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
