package CRUD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteFromDb {
    public static void author(String url, int id){
        String sql = "DELETE FROM authors WHERE author_id = ?";
        try(var conn = DriverManager.getConnection(url);var ps = conn.prepareStatement(sql)) {
            ps.setInt(1,1);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void book(String url, int book_id){
        String sql = "DELETE FROM books WHERE book_id = ?";
        try(var conn = DriverManager.getConnection(url); var ps = conn.prepareStatement(sql)){
            ps.setInt(1, book_id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void finishedBook(String url, int book_id){
        String sql = "DELETE FROM finished_books WHERE book_id = ?";
        try(var conn = DriverManager.getConnection(url); var ps = conn.prepareStatement(sql)){
            ps.setInt(1, book_id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
