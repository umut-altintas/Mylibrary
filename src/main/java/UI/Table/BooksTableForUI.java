package UI.Table;

import CRUD.ConnectToDb;
import CRUD.DeleteFromDb;
import UI.Add.AddFinishedBookUI;
import UI.DataForUI;
import UI.Edit.EditBookUI;

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
    public static Object book_id;
    public static Object book_name;
    public static Object book_type;
    public static Object book_language;
    public static Object book_page_number;
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
            }
        }
        if (e.getSource() == editBook){
            this.removeAll();
            JPanel panel = new EditBookUI();
            this.add(panel);
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == addToFinBook){
            if (ConnectToDb.getFinishedBookByID(url, (Integer) book_id) != 0) {
                JOptionPane.showMessageDialog(new AddFinishedBookUI(),"This book is already finished!",
                        "Error", JOptionPane.PLAIN_MESSAGE);
            } else {
                this.removeAll();
                JPanel panel = new AddFinishedBookUI();
                this.add(panel);
                this.revalidate();
                this.repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        book_id = table.getValueAt(table.getSelectedRow(), 1);
        popupMenu.show(this, e.getX(), e.getY());
        book_name = table.getValueAt(table.getSelectedRow(), 2);
        book_type = table.getValueAt(table.getSelectedRow(), 4);
        book_language = table.getValueAt(table.getSelectedRow(), 5);
        book_page_number = table.getValueAt(table.getSelectedRow(), 6);
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
