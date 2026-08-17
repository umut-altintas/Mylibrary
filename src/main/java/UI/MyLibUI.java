package UI;

import CRUD.CreateDb;
import UI.Add.AddAuthorUI;
import UI.Table.AuthorsTableForUI;
import UI.Table.BooksTableForUI;
import UI.Table.FinishedBooksTableForUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static CRUD.ConnectToDb.url;

public class MyLibUI extends JFrame implements ActionListener{
    JMenuItem authorAdd;
    JMenuItem authorShowAll;
    JMenuItem bookShowAll;
    JMenuItem finBookShowAll;
    public MyLibUI(){
        this.setTitle("My library");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640,640);
        this.setResizable(false);

        ImageIcon book = new ImageIcon("src/main/resources/book.png");
        this.setIconImage(book.getImage());

        JMenuBar menuBar = new JMenuBar();

        JMenu authorMenu = new JMenu("Author");
        JMenu bookMenu = new JMenu("Book");
        JMenu finishedBookMenu = new JMenu("Finished Book");

        authorAdd = new JMenuItem("Add");
        authorShowAll = new JMenuItem("Show all");
        bookShowAll = new JMenuItem("Show all");
        finBookShowAll = new JMenuItem("Show all");

        authorAdd.addActionListener(this);
        authorShowAll.addActionListener(this);
        bookShowAll.addActionListener(this);
        finBookShowAll.addActionListener(this);

        authorMenu.add(authorAdd);
        authorMenu.add(authorShowAll);
        bookMenu.add(bookShowAll);
        finishedBookMenu.add(finBookShowAll);

        menuBar.add(authorMenu);
        menuBar.add(bookMenu);
        menuBar.add(finishedBookMenu);
        this.setJMenuBar(menuBar);


    }


    public static void main(String[] args) {
        CreateDb.create(url);
        SwingUtilities.invokeLater(() -> {
            MyLibUI ui = new MyLibUI();
            ui.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == authorShowAll) {
            this.getContentPane().removeAll();

            JPanel panel = new AuthorsTableForUI();
            this.add(panel);

            this.revalidate();
            this.repaint();
        }
        if(e.getSource() == bookShowAll){
            this.getContentPane().removeAll();

            JPanel panel = new BooksTableForUI();
            this.add(panel);

            this.revalidate();
            this.repaint();
        }
        if(e.getSource() == finBookShowAll){
            this.getContentPane().removeAll();

            JPanel panel = new FinishedBooksTableForUI();
            this.add(panel);

            this.revalidate();
            this.repaint();
        }
        if(e.getSource() == authorAdd){
            this.getContentPane().removeAll();
            JPanel panel = new AddAuthorUI();
            this.add(panel);
            this.revalidate();
            this.repaint();
        }
    }
}
