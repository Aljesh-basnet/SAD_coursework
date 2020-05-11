/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coursework.user_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aljes

 */
public class Signup extends HttpServlet {
    User u = new User();
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            /* TODO output your page here. You may use following sample code. */
           
           u.setUsername(request.getParameter("username"));
           u.setEmail(request.getParameter("email"));
           u.setUser_birthdate(request.getParameter("birthdate"));
           u.setUser_is_admin("false");
           u.setUser_created_date(java.time.LocalDate.now().toString());
           u.setUser_blocked_status("false");
           u.setUser_password1(request.getParameter("password1"));
           u.setUser_passsword2(request.getParameter("password2"));

           Connection con = MyConnection.getConnection();
           String query = "insert into userdb (username,email,birthdate,password,userIsAdmin,userCreatedDate,userBlockedStatus) "
                   + "values (?,?,?,?,?,?,?)";
         
           PreparedStatement ps = con.prepareStatement(query);
           
           
           ps.setString(1,u.getUsername());//setting username in the database
           ps.setString(2,u.getEmail());
           ps.setString(3,u.getUser_birthdate());
           ps.setString(4,u.getUser_password1());
           ps.setString(5,u.getUser_is_admin());
           ps.setString(6,u.getUser_created_date());
           ps.setString(7,u.getUser_blocked_status());
           
           
           if(u.username_exists(request.getParameter("username"))==true || u.password_mismatch()==true){
           out.println("Username exists or password mismatch");
           }
           else if(u.empty_fields_detected()==true){
            out.println("Some fields are empty");
        }
           else{
           ps.executeUpdate();
           
           out.println("Working");
           }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
