import java.sql.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String password = "password";

        String query = "select * from student.student";

        try {
            //step 2
            //Load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 3
            Connection con = DriverManager.getConnection(url, userName, password);

            //step 4
            Statement st = con.createStatement();

            //step 5
            ResultSet rs = st.executeQuery(query);

            //step 6
            while(rs.next()) {
                String userData = rs.getInt(1) + " " + rs.getString(2);
                System.out.println(userData);
            }

            //step7
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!!!!");
            e.printStackTrace();
        }
    }
}