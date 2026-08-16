package CRUD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConnectToDb {
    public static final String url = "jdbc:sqlite:test.db";

    public static List<Authors> getAuthorsTable(String url){
        String query = "SELECT author_id, author_name, author_score FROM authors";
        List<Authors> authors = new ArrayList<>();
        try (var conn = DriverManager.getConnection(url); var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
            while(rs.next()){
                int id = rs.getInt("author_id");
                String name = rs.getString("author_name");
                String score = rs.getString("author_score");
                authors.add(new Authors(id, name, score));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return authors;
    }
    public static LocalDateTime getBookAddedDate(String url, int book_id){
        String sql = "SELECT b.book_added_date FROM books AS b WHERE b.book_id = ?";
        try(var conn = DriverManager.getConnection(url);var ps = conn.prepareStatement(sql)){
            ps.setInt(1, book_id);
            ResultSet rs = ps.executeQuery();
            String book_added_date = rs.getString("book_added_date");
            return LocalDateTime.parse(book_added_date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Books> getBooksTable(String Url){
        String query = "SELECT author_id, book_id, book_name, book_added_date, book_type, book_language, book_page_number FROM books";
        List<Books> books = new ArrayList<>();
        try (var conn = DriverManager.getConnection(url); var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
            while (rs.next()){
                int author_id = rs.getInt("author_id");
                int book_id = rs.getInt("book_id");
                String book_name = rs.getString("book_name");
                String book_added_date = rs.getString("book_added_date");
                String book_type = rs.getString("book_type");
                String book_language = rs.getString("book_language");
                int book_page_number = rs.getInt("book_page_number");
                books.add(new Books(author_id,book_id,book_name,book_added_date,book_type,book_language,book_page_number));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    public static List<FinishedBooks> getFinishedBooksTable(String url){
        String query = "SELECT book_id, book_finished_date, book_read_time, book_score, book_summary FROM finished_books";
        List<FinishedBooks> finishedBooks = new ArrayList<>();
        try (var conn = DriverManager.getConnection(url); var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
            while (rs.next()){
                int book_id = rs.getInt("book_id");
                String book_finished_date = rs.getString("book_finished_date");
                String book_read_time = rs.getString("book_read_time");
                int book_score = rs.getInt("book_score");
                String book_summary = rs.getString("book_summary");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return finishedBooks;
    }
}
