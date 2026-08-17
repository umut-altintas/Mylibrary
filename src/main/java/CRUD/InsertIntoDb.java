package CRUD;

import UI.Add.AddFinishedBookUI;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class InsertIntoDb {
    public static void author(String url, String author_name){
        String sql = "INSERT INTO authors(author_name) VALUES (?)";
        try (var conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); var ps = conn.prepareStatement(sql)) {
            stmt.execute("PRAGMA foreign_keys = ON");
            ps.setString(1, author_name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        }
    public static void book(String url, int author_id, String book_name, String book_type, String book_language, int book_page_number){
        String sql = "INSERT INTO books(author_id ,book_name, book_added_date, book_type, book_language, book_page_number) VALUES (?,?,?,?,?,?)";
        LocalDateTime now = LocalDateTime.now();
        try(var conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); var ps = conn.prepareStatement(sql)) {
            stmt.execute("PRAGMA foreign_keys = ON");
            ps.setInt(1, author_id);
            ps.setString(2, book_name);
            ps.setObject(3, now);
            ps.setString(4, book_type);
            ps.setString(5, book_language);
            ps.setInt(6, book_page_number);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        }
    public static boolean finishedBook(String url, int book_id, int book_score, String book_summary){
        String sql = "INSERT INTO finished_books(book_id, book_finished_date, book_read_time," +
                " book_score, book_summary) VALUES (?,?,?,?,?)";
        String book_read_time = GetTime.timeDiff(url, book_id);
        try(var conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement(); var ps = conn.prepareStatement(sql)) {
            stmt.execute("PRAGMA foreign_keys = ON");
            ps.setInt(1, book_id);
            ps.setObject(2, LocalDateTime.now());
            ps.setString(3, book_read_time);
            ps.setInt(4, book_score);
            ps.setString(5, book_summary);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new AddFinishedBookUI(),"This book is already finished!",
                    "Error", JOptionPane.PLAIN_MESSAGE);
            return false;
            }
        }

    }

