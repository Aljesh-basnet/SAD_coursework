
package com.mycompany.user_management;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.user_management.UserDbUtil;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author abishek
 */
@WebServlet(name = "UserControllerServlet", urlPatterns = {"/UserControllerServlet"})
public class UserControllerServlet extends HttpServlet {
    
    private UserDbUtil doa;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        try{
        doa = new UserDbUtil();
        }
        catch(Exception exc)
        {
        throw new ServletException(exc);
        }
        
    }
    
    

   
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
         //list the students .... in MVC fashion
         
         try{
             //read the "command" parameter
             String theCommand = request.getParameter("command");
             
             //if the command is missing , then defaulr to listing user
             
             if(theCommand == null)
             {
             theCommand = "LIST";
             }
             
             //route to the approprate method
             switch(theCommand)
             {
                 case "LIST":
                     listUser(request,response);
                     break;
                     
                 case "ADD":
                     addUser(request,response);
                     break;
                     
                 case "LOAD":
                     loadUser(request,response);
                     break;
                     
                     
                 case "UPDATE":
                     updateUser(request,response);
                     break;
                     
                 case "DELETE":
                     delUser(request,response);
                     break;
                     
                     
                     
                     
                     
                 default:
                     listUser(request,response);
                     
                   
                     
             
             }
             
         }catch(Exception exc)
         {throw new ServletException(exc);}
         
         
         
         
         
   }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //get user from db util
        PrintWriter out = response.getWriter();
        List<User> users = doa.getUser();
        
        
        //add user to the reques
        request.setAttribute("user_list", doa.getUser());
        
        //send to JSP page(view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listUser.jsp");
        dispatcher.forward(request,response);
        
        
        
        
        
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //read user info from form data
//         int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        
        //crreate a new user object
        User theUser = new User(firstName,lastName,email,address,dob);
        
        //add the student to the database
        doa.addUser(theUser);
        
        //send back to main page 
         listUser(request,response);
        
        
        
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        //read user info from the data
        
        int id = Integer.parseInt(request.getParameter("uId"));
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        
    // create a new user object
		User theUser = new User(id, firstName, lastName, email, address, dob);
		
		// perform update on database
		doa.updateUser(theUser);
		
		// send them back to the "list students" page
		listUser(request, response);
        
        
    }

    private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
      
        //read user id from form data
        int theUserId = Integer.parseInt(request.getParameter("userId")) ;
        
        //get user from database(db util)
        User theUser = doa.getUser(theUserId);
        
        
        //place student in the request attribute
        request.setAttribute("THE_USER", theUser);
        
        //send to jsp page update-user-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update_user_form.jsp");
        dispatcher.forward(request, response);
        
    }

    private void delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        
        //read user id from form data
        String theUserId = request.getParameter("userId");
        
        
        
        //delete student from database
        doa.delUser(theUserId);
        
        //send them back to "list students" page
       listUser(request, response);
        
        
        
        
    }

   

}
