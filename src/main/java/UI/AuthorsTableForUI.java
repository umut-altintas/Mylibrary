package UI;

import CRUD.ConnectToDb;
import CRUD.DeleteFromDb;
import CRUD.UpdateDb;
import InputHandling.StringHandler;

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
    JMenuItem editAuthor;
    public static Object author_id;

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
        editAuthor = new JMenuItem("Edit author");
        editAuthor.addActionListener(this);
        popupMenu.add(editAuthor);
    }
    public void refreshPage(){
        this.removeAll();
        JPanel panel = new AuthorsTableForUI();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        author_id = table.getValueAt(table.getSelectedRow(), 0);
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
        if (e.getSource() == addBook){
            this.removeAll();
            JPanel panel = new AddBookUI();
            this.add(panel);
            this.revalidate();
            this.repaint();
        }
        if (e.getSource() == deleteAuthor){
            int input  = JOptionPane.showConfirmDialog(this, "Do you want to delete this author?", "Delete author", JOptionPane.YES_NO_OPTION);
            if(input == 0){
                DeleteFromDb.author(url, (Integer) author_id);
                refreshPage();
            }else{
                refreshPage();
            }

        }
        if (e.getSource() == editAuthor){
            String input = JOptionPane.showInputDialog(this, "New name: ", "Edit Author", JOptionPane.PLAIN_MESSAGE);
            if(input.isBlank()){
                JOptionPane.showMessageDialog(this, "All field must be filled!");
            }else{
                String name = StringHandler.Name(input);
                UpdateDb.authorName(url, (Integer) author_id, name);
                refreshPage();
            }
        }
    }
}
