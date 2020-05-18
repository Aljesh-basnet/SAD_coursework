<%-- 
    Document   : add_user_form
    Created on : 12 May 2020, 07:51:16
    Author     : abish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h3>Add User</h3>
            
            <form action="UserControllerServlet" method="GET">
                
                <input type="hidden" name="command" value="ADD"/>
                
                <table>
                    <tbody>
                            
                        <tr>
                             <td><label>First Name: </label></td>
                            <td><input type="text" name="fname"/></td>
                            </tr>
                            
                            <tr>
                             <td><label>Lat Name: </label></td>
                            <td><input type="text" name="lname"/></td>
                            </tr>
                            
                            <tr>
                             <td><label>Email: </label></td>
                            <td><input type="text" name="email"/></td>
                            </tr>
                            
                            <tr>
                             <td><label>Address: </label></td>
                            <td><input type="text" name="address"/></td>
                            </tr>
                            
                            <tr>
                             <td><label>DOB: </label></td>
                            <td><input type="text" name="dob"/></td>
                            </tr>
                            
                            <tr>
                            
                             <td><label></label></td>
                             <td><input class="save" type="submit" value="Submit"/></td>
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
