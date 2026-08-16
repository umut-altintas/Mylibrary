
import UI.MyLibUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyLibUI ui = new MyLibUI();
            ui.setVisible(true);
        });
    }
}
