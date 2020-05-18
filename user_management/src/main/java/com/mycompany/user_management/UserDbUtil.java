
package com.mycompany.user_management;

/**
 *
 * @author abishek
 */

import JDBC_Connection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.user_management.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDbUtil {

   
    
    private Connection conn;
    
    public UserDbUtil()
    {
    conn = ConnectionProvider.getConnection();
    
    }
    
    public List<User> getUser() throws Exception
    {
    List<User> users = new ArrayList<>();
    
    
    
//    try{
//    
//        //Write sql query
//        String sql = "Select * from user where id = 1";
//        
//        
//        //get a connection
//        PreparedStatement ps = conn.prepareStatement(sql);
//       
//        //execute query
//        
//       ResultSet rs = ps.executeQuery();
//       
//       //process result set
//       
//       while(rs.next())
//       {
//       User user = new User();
//       
//       user.setId(rs.getInt("id"));
//       user.setFirstName(rs.getString("firstName"));
//       user.setLastName(rs.getString("lastName"));
//       user.setEmail(rs.getString("email"));
//       user.setAddress(rs.getString("address"));
//       user.setDate_of_birth(rs.getString("dob"));
//       
//       users.add(user);
//       
//       }
//    
//    }catch (SQLException e){e.printStackTrace();}
//    
//    return users;
//    
    
    Statement stm = null;
    ResultSet rs = null;
    
    try{
    //get a connection
    
    
    //create sql statement
    String sql = "select * from user";
    stm = conn.createStatement();
    
    //execute query
    rs = stm.executeQuery(sql);
    
    
    //process result set
    while(rs.next())
    {
    
        //retrieve data from result set row
        
        int id = Integer.parseInt(rs.getString("id"));
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String email = rs.getString("email");
        String address = rs.getString("address");
        String dob = rs.getString("dob");
        
        //ccreate new user object
        User tempUser = new User(id,firstName,lastName,email,address,dob);
        
        //add it to the list of student
        
        users.add(tempUser);
    
    }

    
    return users;
    }
    
    finally{

    //close JDBC objects
    
    close(conn,stm,rs);
    
    }
    
    
        
        
    }

    private void close(Connection conn, Statement stm, ResultSet rs) {
        try {
        if(rs != null)
        {
        rs.close();
        }
        
        if (stm != null)
        {
        
        stm.close();
        }
        
        if (conn != null)
        {
        rs.close();
        }
        
        
        
        }
        
        catch(Exception exc)
        {exc.printStackTrace();}
    }
    
     public  void addUser(User theUser) throws Exception {
         
         PreparedStatement stm = null;
         
         
       try{
         //creaate sql for insert
         String sql = "insert into user" 
                 + "(firstName,lastName,email,address,dob)"
                 +"values(?,?,?,?,?)";
         
         stm = conn.prepareStatement(sql);
         
         //set the param values for the user
//         stm.setInt(1, theUser.getId());
         stm.setString(1, theUser.getFirstName());
         stm.setString(2, theUser.getLastName());
         stm.setString(3,theUser.getEmail());
         stm.setString(4,theUser.getAddress());
         stm.setString(5, theUser.getDate_of_birth());
         
         //execute sql insert
         stm.execute();
         
         
       }
         
        finally{ 
         //clean up JDBC objects
         close(conn,stm,null);
         
         
       }
         
         
    }
     
        public User getUser(int theUserId) throws Exception{
        
        User theUser = null;
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        int userId;
        
        try
        {
        //convert user id to int
            userId = theUserId;
            
     
            
            //create sql to get selected user
            String sql = "select * from user where id=?";
            
            
            //create prepared statement
            stm = conn.prepareStatement(sql);
            
            
            
            
            //set params
            stm.setInt(1, userId);
            
            
            
            //execute statement
            rs = stm.executeQuery();
            
            //retriebe data from result set row
        if(rs.next())
        {
           int id = rs.getInt("id");
        String firstName = rs.getString("firstName");
         String lastName = rs.getString("lastName");
          String email = rs.getString("email");
           String address = rs.getString("address");
            String dob = rs.getString("dob");
            
            //use the userId during construction
            
            theUser = new User(id,firstName,lastName,email,address,dob);
            
        }
        else
        {
        throw new Exception("Could not find user id:" + userId);
        }
        
        
         return theUser;
        
        }
        finally
        {
        //clean uup JDBC objects
            close(conn,stm,rs);
        
        }
        
        
        
        
        
        
        
       
        
        
    }
    

    public void updateUser(User theUser) throws Exception {
        
        PreparedStatement stm = null;
        
        try{
        //creaate sql for insert
        String sql = "update user set firstName=?, lastName=?, email=?, address=?, dob=? where id=?";
               
        
        stm = conn.prepareStatement(sql);
        
        
        //set the param values for the user
        stm.setString(1, theUser.getFirstName());
        stm.setString(2, theUser.getLastName());
        stm.setString(3, theUser.getEmail());
        stm.setString(4, theUser.getAddress());
        stm.setString(5, theUser.getDate_of_birth());
        stm.setInt(6, theUser.getId());

         //execute sql insert
         
         stm.execute();
         
        }
        finally
        {
        
        close(conn ,stm ,null);
        }
        
        
    }

    public void delUser(String theUserId) throws Exception {
        
        PreparedStatement stm = null;
        
        try
        {
        
      // convert user id to int
		int userId = Integer.parseInt(theUserId);
			
			
			
			// create sql to delete student
		String sql = "delete from user where id=?";
			
			// prepare statement
		stm = conn.prepareStatement(sql);
			
			// set params
                stm.setInt(1, userId);
			
			// execute sql statement
		stm.execute();
        
        
        
        
        }
        finally
        {
        close(conn,stm,null);
        
        }
        
        
        
    }

 
}
