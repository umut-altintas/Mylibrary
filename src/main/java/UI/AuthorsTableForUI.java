package UI;

import CRUD.ConnectToDb;
import CRUD.DeleteFromDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static CRUD.ConnectToDb.url;

public class AuthorsTableForUI extends JPanel implements MouseListener, ActionListener {
    JTable table;
    JPopupMenu popupMenu;
    JMenuItem addBook;
    JMenuItem deleteAuthor;
    public static Object book_id;

    public AuthorsTableForUI() {
        this.setLayout(new BorderLayout());
        DataForUI d = new DataForUI();
        Object data = d.authors(url);
        String[] columnNames = {"Id", "Name", "Rating"};
        table = new JTable((Object[][]) data, columnNames);
        table.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        popupMenu = new JPopupMenu();
        //Add book menuItem
        addBook = new JMenuItem("Add book");
        addBook.addActionListener(this);
        popupMenu.add(addBook);
        //Delete author menuItem
        deleteAuthor = new JMenuItem("Delete author");
        deleteAuthor.addActionListener(this);
        popupMenu.add(deleteAuthor);
        //Edit author menuItem

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        book_id = table.getValueAt(table.getSelectedRow(), 0);
        popupMenu.show(this, e.getX(), e.getY());
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
        if (e.getSource() == addBook) {
            System.out.println(book_id);
            this.removeAll();

            JPanel panel = new AddBookUI();
            this.add(panel);

            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == deleteAuthor){
            DeleteFromDb.author(url, (Integer) book_id);
            this.removeAll();

            JPanel panel = new AuthorsTableForUI();
            this.add(panel);

            this.revalidate();
            this.repaint();
        }
    }
}
