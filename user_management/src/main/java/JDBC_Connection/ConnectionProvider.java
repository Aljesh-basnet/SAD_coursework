
package JDBC_Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abishek
 */
public class ConnectionProvider {
    
      private static Connection con = null;

    public static Connection getConnection() {
        if (con != null)
            return con;
        else {
            try {
                
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/user_management";
                String user = "root";
                String password = "admin";
                
                Class.forName(driver);
                con =  DriverManager.getConnection(url, user, password);
                
                
                
                //checking
                
               
        
//        Statement s = con.createStatement();
//        ResultSet r = s.executeQuery("select * from user");
//        
//        r.next();
//        String name = r.getString("firstName");
//        System.out.println(name);
//        s.close();
//        con.close();
//                
                
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            } 
            return con;
        }

    }
    
//   public static void main (String args[])
//           
//   {
//   
//   ConnectionProvider c = new ConnectionProvider();
//   c.getConnection();
//   
//   }
    
  }
