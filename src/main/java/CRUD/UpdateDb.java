package CRUD;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDb {
    public static void authorName(String url, int id, String name){
        String sql = "UPDATE authors SET author_name = ? WHERE author_id = ?";
        try (var conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); var ps = conn.prepareStatement(sql)) {
            stmt.execute("PRAGMA foreign_keys = ON");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void book(String url, int book_id, String book_name,
                            String book_type, String book_language, int book_page_number){
        String sql = "UPDATE books SET book_name = ?, book_type = ?, book_language = ?," +
                "book_page_number = ? WHERE book_id = ?";
        try (var conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); var ps = conn.prepareStatement(sql)) {
            stmt.execute("PRAGMA foreign_keys = ON");
            ps.setString(1, book_name);
            ps.setString(2, book_type);
            ps.setString(3, book_language);
            ps.setInt(4, book_page_number);
            ps.setInt(5, book_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
