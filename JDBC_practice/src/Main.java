/*
Jdbc requires 7 steps
1.import the package  (java.sql.*)
2.load and register the driver --> type of driver depends on database for eg mysql driver for mysql and oracle for orcale.
3.create a connection using object of connection interface.
4.create a statement using object of statement interface.
5.execute the query
6.process the results
7.close

above steps can be modified as per requirement

mysql driver name - com.mysql.jdbc.Driver but it is not in system by default we have to download mysql connector jar file
from maven repo.

TO load the driver :->
go to file project structure
go to library
add jar file.

for Name is method which will help to load the class

we need to search for method which will give me instance of the interface connection and that is "getConnection"
getConnection is static method of driver manager.
we need to pass three parameter 1. url 2. username 3. password
 */

//step1

import java.sql.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/demo";
        String userName = "root";
        String password = "password";

        String query="select user_name from student.student where user_id=1";

        try{
        //step 2
        //Load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //step 3
        Connection con = DriverManager.getConnection(url,userName,password);

        //step 4
        Statement st = con.createStatement();

        //step 5
        ResultSet rs =st.executeQuery(query);

        //step 6
        rs.next();
        String name=rs.getString("user_name");

        System.out.println(name);

        //step7
        st.close();
        con.close();

    }
  catch (ClassNotFoundException e)
    {
        System.out.println("Class not found!!!!");
        e.printStackTrace();
    }
    }
}