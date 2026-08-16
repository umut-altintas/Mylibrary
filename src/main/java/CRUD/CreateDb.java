package CRUD;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDb {
    public static void create(String url) {
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            String filePath = "src/main/resources/CRUD.CreateDb.sql";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // String Builder to build the query line by line.
            StringBuilder query = new StringBuilder();
            String line;

            while((line = br.readLine()) != null) {

                if(line.trim().startsWith("-- ")) {
                    continue;
                }

                // Append the line into the query string and add authors space after that
                query.append(line).append(" ");

                if(line.trim().endsWith(";")) {
                    // Execute the Query
                    stmt.execute(query.toString().trim());
                    // Empty the Query string to add new query from the file
                    query = new StringBuilder();
                }
            }
            stmt.execute(query.toString().trim());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
