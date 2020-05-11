/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coursework.user_management;

/**
 *
 * @author aljes
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aljesh
 */
public class User {
    
    private int user_id;
    private String username;
    private String email;
    private String user_birthdate;
    private String user_password1;
    private String user_password2;
    private String user_is_admin;
    private String user_blocked_status;
    private String user_created_date;  
    
    
    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    

    /**
     * @return the user_birthdate
     */
    public String getUser_birthdate() {
        return user_birthdate;
    }

    /**
     * @param user_birthdate the user_birthdate to set
     */
    public void setUser_birthdate(String user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    /**
     * @return the user_password1
     */
    public String getUser_password1() {
        return user_password1;
    }

    /**
     * @param user_password1 the user_password1 to set
     */
    public void setUser_password1(String user_password1) {
        this.user_password1 = user_password1;
    }

    /**
     * @return the user_passsword2
     */
    public String getUser_password2() {
        return user_password2;
    }

    /**
     * @param user_password2
     */
public void setUser_passsword2(String user_password2) {
        this.user_password2 = user_password2;
    }

    /**
     * @return the user_is_admin
     */
    public String getUser_is_admin() {
        return user_is_admin;
    }

    /**
     * @param user_is_admin the user_is_admin to set
     */
    public void setUser_is_admin(String user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    /**
     * @return the user_blocked_status
     */
    public String getUser_blocked_status() {
        return user_blocked_status;
    }

    /**
     * @param user_blocked_status the user_blocked_status to set
     */
    public void setUser_blocked_status(String user_blocked_status) {
        this.user_blocked_status = user_blocked_status;
    }

    /**
     * @return the user_created_date
     */
    public String getUser_created_date() {
        return user_created_date;
    }

    /**
     * @param user_created_date the user_created_date to set
     */
    public void setUser_created_date(String user_created_date) {
        this.user_created_date = user_created_date;
    }
    
    
    public boolean username_exists(String username) throws SQLException{  //Code of checking username uniqueness
        Boolean result = false;
        String query="select * from userdb where username = ?";
        
        PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
        st.setString(1, username); //username is set on the prepared statement
        ResultSet r1=st.executeQuery();
            if(r1.next()) {
            result = true;
            }
        
        return result;
}
    
    public boolean empty_fields_detected(){
        if(username.isEmpty() ||email.isEmpty() ||user_birthdate.isEmpty() ||user_password1.isEmpty() ||user_password2.isEmpty()){
            return true;
        }
        else return false;
    }
    
    public boolean password_mismatch(){
    if(user_password1.equals(user_password2)){
        return false;
    }
    else return true;
    }

    
}
