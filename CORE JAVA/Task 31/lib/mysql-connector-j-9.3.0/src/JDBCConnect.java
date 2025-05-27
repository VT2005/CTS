import java.sql.*;

public class JDBCConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SchoolDB";
        String user = "root"; // change to your MySQL username
        String password = ""; // your password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("age"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
