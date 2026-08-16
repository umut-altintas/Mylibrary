package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLibUI extends JFrame implements ActionListener{
    JMenuItem authorAdd;
    JMenuItem authorShowAll;
    JMenuItem bookAdd;
    JMenuItem bookShowAll;
    JMenuItem finBookAdd;
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
        bookAdd = new JMenuItem("Add");
        bookShowAll = new JMenuItem("Show all");
        finBookAdd = new JMenuItem("Add");
        finBookShowAll = new JMenuItem("Show all");

        authorAdd.addActionListener(this);
        authorShowAll.addActionListener(this);
        bookAdd.addActionListener(this);
        bookShowAll.addActionListener(this);
        finBookAdd.addActionListener(this);
        finBookShowAll.addActionListener(this);

        authorMenu.add(authorAdd);
        authorMenu.add(authorShowAll);
        bookMenu.add(bookAdd);
        bookMenu.add(bookShowAll);
        finishedBookMenu.add(finBookAdd);
        finishedBookMenu.add(finBookShowAll);

        menuBar.add(authorMenu);
        menuBar.add(bookMenu);
        menuBar.add(finishedBookMenu);
        this.setJMenuBar(menuBar);


    }


    public static void main(String[] args) {
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
        if(e.getSource() == bookAdd){
            this.getContentPane().removeAll();
            JPanel panel = new AddBookUI();
            this.add(panel);
            this.revalidate();
            this.repaint();
        }
    }
}
