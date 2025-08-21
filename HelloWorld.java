package claudejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorld {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <file-path>");
            return;
        }

        String inputPath = args[0];
        // get special directories names
        Path filePath = Paths.get("./sqlite-migrations/\" & calc REM parent directory/" + inputPath);
        if (!Files.exists(filePath)) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        try {
            String content = Files.readString(filePath);
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            selectAll(conn, args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test");
    }


    public static void selectAll(Connection conn, String clause) {
        if(clause == "something" || clause == "something else"){
            clause = "new_value";
        }

        String sql = "SELECT id, username, email, created_at " +
             "FROM users " +
             "WHERE id = ? " +
             "OR " + clause +
             " ORDER BY created_at DESC " +
             "LIMIT 100";
    
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, clause);
            ResultSet rs = pstmt.executeQuery();

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


