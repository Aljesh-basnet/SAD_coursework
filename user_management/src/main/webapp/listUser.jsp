<%-- 
    Document   : list_user
    Created on : 11 May 2020, 21:25:33
    Author     : abish
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mycompany.user_management.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <title>User Management List</title>
    </head>
    

    
    
    <body>
        <div id ="wrapper">
            <div id ="header">
                <h2>User Management</h2>
                
            </div>
        </div>
        
        
        <div id="container">
            
            <div id="content">
                
                <input type="button" value="Add User" onclick="window.location.href='add_user_form.jsp';return false;"
                       class="add-user-button"/>
                
                <table>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>DOB</th>
                        <th>Action</th>
                        
                    </tr>
                    
                    <c:forEach var="tempUser" items="${user_list}">
                        
                        <!-- set up a link for each user    -->
                        <c:url var="tempLink" value="UserControllerServlet">
                            <c:param name="command" value="LOAD"/>
                            <c:param name="userId" value="${tempUser.id}"/>
                            
                        </c:url>
                        
                        <!--set up a link to delete a user -->
                           <c:url var="delLink" value="UserControllerServlet">
                            <c:param name="command" value="DELETE"/>
                            <c:param name="userId" value="${tempUser.id}"/>
                            
                        </c:url>
                        
                        
                    <tr>
                        <td>${tempUser.id}</td>
                        <td>${tempUser.firstName}</td>
                        <td>${tempUser.lastName}</td>
                        <td>${tempUser.email}</td>
                        <td>${tempUser.address}</td>
                        <td>${tempUser.date_of_birth}</td>
                        <td><a href="${tempLink}">
                            Update
                                
                            </a>
                             |
                             <a href="${delLink}" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
                           
                            Delete
                                
                            </a>
                        
                        </td>
                        
                        
                        
                        
                    </tr>
                    </c:forEach>
                    
                    
                </table>
                
                
                
            </div>
            
            
            
            
        </div>
        
        
        
        
        
        
    </body>
</html>
