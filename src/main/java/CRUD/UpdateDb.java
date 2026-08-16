package CRUD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateDb {
    public static void authorName(String url, int id, String name){
        String sql = "UPDATE authors SET author_name = ? WHERE author_id = ?";
        try (var conn = DriverManager.getConnection(url); var ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
