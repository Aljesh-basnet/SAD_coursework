<%-- 
    Document   : add_user_form
    Created on : 12 May 2020, 07:51:16
    Author     : abish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mycompany.user_management.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  rel="stylesheet" href="css/style.css">
        <link type="text/css"   rel="stylesheet" href="css/add-user-style.css">
        <title>User Management</title>
    </head>
    <body>
        
        <div id="wrapper">
            <div id="header">
                <h2>User Management</h2>
            </div>
        </div>
        
        <div id="container">
            <h3>Update User</h3>
            
            <form action="UserControllerServlet" method="GET">
                
                <input type="hidden" name="command" value="UPDATE"/>
                
                <input type="hidden" name="uId" value="${THE_USER.id}"/>
                
                
                <table>
                    <tbody>
                            
                        <tr>
                             <td><label>First Name: </label></td>
                            <td><input type="text" name="fname"
                                       value="${THE_USER.firstName}"
                                       /></td>
                            </tr>
                            
                            <tr>
                             <td><label>Lat Name: </label></td>
                            <td><input type="text" name="lname"
                                       value="${THE_USER.lastName}"
                                       /></td>
                            </tr>
                            
                            <tr>
                             <td><label>Email: </label></td>
                            <td><input type="text" name="email"
                                       value="${THE_USER.email}"
                                       
                                       /></td>
                            </tr>
                            
                            <tr>
                             <td><label>Address: </label></td>
                            <td><input type="text" name="address"
                                       value="${THE_USER.address}"
                                       /></td>
                            </tr>
                            
                            <tr>
                             <td><label>DOB: </label></td>
                            <td><input type="text" name="dob"
                                       value="${THE_USER.date_of_birth}"
                                       /></td>
                            </tr>
                            
                            <tr>
                            
                             <td><label></label></td>
                             <td><input class="save" type="submit" value="Save"/></td>
                        </tr>
                        
                        
                        
                    </tbody>
                    
                    
                    
                </table>
                
                
                
                
            </form>
            <div style="clear:both;"></div>

            <p>
                <a href="UserControllerServlet">Back To List</a>
            </p>
            
        </div>
        
        
        
        
        
    </body>
</html>
