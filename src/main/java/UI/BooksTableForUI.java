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

public class BooksTableForUI extends JPanel implements MouseListener, ActionListener {
    JTable table;
    JPopupMenu popupMenu;
    JMenuItem deleteBook;
    JMenuItem editBook;
    JMenuItem addToFinBook;
    Object book_id;
    public BooksTableForUI(){
        this.setLayout(new BorderLayout());
        DataForUI d = new DataForUI();
        Object data = d.books(ConnectToDb.url);
        String[] columnNames = {"Author id", "Book id", "Name", "Added date", "Type", "Language", "Page number"};
        table = new JTable((Object[][]) data, columnNames);
        table.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        //Popup menu
        popupMenu = new JPopupMenu();
        //Delete book
        deleteBook = new JMenuItem("Delete");
        deleteBook.addActionListener(this);
        popupMenu.add(deleteBook);
        //Edit book
        editBook = new JMenuItem("Edit");
        editBook.addActionListener(this);
        popupMenu.add(editBook);
        //Add to finished books table
        addToFinBook = new JMenuItem("Mark as Finished");
        addToFinBook.addActionListener(this);
        popupMenu.add(addToFinBook);
    }
    public void refreshPage(){
        this.removeAll();
        JPanel panel = new BooksTableForUI();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteBook){
            int input  = JOptionPane.showConfirmDialog(this, "Do you want to delete this book?",
                    "Delete book", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(input == 0){
                DeleteFromDb.book(url, (Integer) book_id);
                refreshPage();
            }else{
                refreshPage();
            }
        }
        if (e.getSource() == editBook){

        }
        if (e.getSource() == addToFinBook){

        }
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
}
