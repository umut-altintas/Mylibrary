package UI;

import CRUD.*;
import java.util.List;

public class DataForUI {
    public Object authors(String url){
        List<Authors> authors = ConnectToDb.getAuthorsTable(url);
        Object[][] data = new Object[authors.size()][3];

        for (int i = 0; i < authors.size(); i++) {
            Authors author = authors.get(i);
            data[i][0] = author.getId();
            data[i][1] = author.getName();
            data[i][2] = author.getScore();
        }
        return data;
    }
    public Object books(String url){
        List<Books> books = ConnectToDb.getBooksTable(url);
        Object[][] data = new Object[books.size()][7];

        for (int i = 0; i < books.size(); i++){
            Books book = books.get(i);
            data[i][0] = book.getAuthor_id();
            data[i][1] = book.getBook_id();
            data[i][2] = book.getBook_name();
            data[i][3] = book.getBook_added_date();
            data[i][4] = book.getBook_type();
            data[i][5] = book.getBook_language();
            data[i][6] = book.getBook_page_number();
        }
        return data;
    }
    public Object finishedBooks(String url){
        List<FinishedBooks> finishedBooks = ConnectToDb.getFinishedBooksTable(ConnectToDb.url);
        Object[][] data = new Object[finishedBooks.size()][5];

        for (int i = 0; i < finishedBooks.size(); i++){
            FinishedBooks fbook = finishedBooks.get(i);
            data[i][0] = fbook.getBook_id();
            data[i][1] = fbook.getBook_finished_date();
            data[i][2] = fbook.getBook_read_time();
            data[i][3] = fbook.getBook_score();
            data[i][4] = fbook.getBook_summary();
        }
        return data;
    }
}
