import java.lang.reflect.Type;
import java.sql.*;

public class ResultsetMeradata {
    public static void main(String[] args) {
        try {
            Class.forName = ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spu", "root", "pwd");
            Statement stmt = conn.createStatement(ResultSet, Type_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("total column" + rsmd.getColumnCount());
            System.out.println("column Name of the 1 st column" + rsmd.getColumnName(1));
            System.out.println("column type name of the first column" + rsmd.getColumnType(1));
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
