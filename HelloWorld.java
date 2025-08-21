package claudejava;

import static claudejava.more.Utils.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {

    public static void main(String[] args) {
        eval("Hello, World!");
        setInterval("alert('code-injection')");
        setTimeout("alert('code-injection')");
        exec("alert('code-injection')");
        write("Hello, World!");

        evaluate(args[2]);
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            selectAll(conn, "users");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test");
    }

    public static void evaluate(String input) {
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

    public static void selectAll(Connection conn, String input) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, input);
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
