import java.sql.*;

/**
 * callbackSatment
 */
public class callbackSatment {
    public static void main(String[] args) {
        try {
            Class.forName = ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spu", "root", "pwd");

            callbackSatment cs = conn.preparecall("{call gettitle(?,?)}");
            cs.setInt(1, 1201);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            System.out.println(cs.getString(2));

            cs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}