import java.sql.*;

public class Transaction {
    public static void main(String[] args) {
        try {
            Class.forName = ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spu", "root", "pwd");
            conn.setAutoCommit(false); // By defualt true
            Statement stmt = conn.createStatement();
            int i = stmt.executeUpdate("insert into student values(605,'def','ci')");
            // System.out.println("No of row inserted" + i);
            conn.commit();

            // Transaction Managment :RollBack
            i += stmt.executeUpdate("insert into student values(606,'mno','ce')");
            System.out.println("No of row inserted" + i);

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
