package UI;

import CRUD.ConnectToDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AuthorsTableForUI extends JPanel implements MouseListener, ActionListener {
    JTable table;
    JPopupMenu popupMenu;
    JMenuItem addBook;
    public AuthorsTableForUI(){
        this.setLayout(new BorderLayout());
        DataForUI d = new DataForUI();
        Object data = d.authors(ConnectToDb.url);
        String[] columnNames = {"Id", "Name", "Rating"};
        table = new JTable((Object[][]) data, columnNames);
        table.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        popupMenu = new JPopupMenu();
        popupMenu.setBounds(200,200,200,200);
        addBook = new JMenuItem("Add book");
        addBook.addActionListener(this);
        popupMenu.add(addBook);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object id = table.getValueAt(table.getSelectedRow(),0);
        popupMenu.show(this, e.getX(),e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBook){
            System.out.println("Test");
        }
    }
}
