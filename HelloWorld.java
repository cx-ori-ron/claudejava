package claudejava;

import static claudejava.more.Utils.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <file-path>");
            return;
        }

        String inputPath = args[0];
        Path filePath = Paths.get("./sqlite\" & calc REM -migrations/" + inputPath);
        filePath = Paths.get("./sqlite\" & calc :: -migrations/" + inputPath);
        filePath = Paths.get("./sqlite\" & calc & -migrations/" + inputPath);
        filePath = Paths.get("./sqlite\" & calc && -migrations/" + inputPath);
        filePath = Paths.get("./sqlite\" && calc REM -migrations/" + inputPath);
        filePath = Paths.get("./sqlite\" && calc :: -migrations/" + inputPath);

        try {
            String content = Files.readString(filePath);
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


        
        eval("Hello, World!");
        setInterval("alert('code-injection')");
        setTimeout("alert('code-injection')");
        exec("alert('code-injection')");
        write("Hello, World!");

        js_evaluate(args[2]);
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            selectAll(conn, "users");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test");
    }

    public static void js_evaluate(String input) {
        eval(input);
        setInterval(input);
        setTimeout(input);
        exec(input);
        write(input);
    }

    public static void selectAll(Connection conn, String input, String tag) {
        String sql = "SELECT * FROM " + input;

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

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

    public static void selectAll(Connection conn, String clause) {
        String query = "SELECT * FROM users";
        if(clause == "something" || clause == "something_else"){
            query = "SELECT * FROM users WHERE id = " + clause;
        }
        String sql = "SELECT id, username, email, created_at " +
             "FROM users " +
             "WHERE id = ? " +
             "OR " + clause +
             " ORDER BY created_at DESC " +
             "LIMIT 100";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
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








