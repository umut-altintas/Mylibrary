
import CRUD.DeleteFromDb;
import UI.MyLibUI;

import javax.swing.*;

import static CRUD.ConnectToDb.url;

public class Main {
    public static void main(String[] args) {
        DeleteFromDb.author(url, 6);
    }
}
