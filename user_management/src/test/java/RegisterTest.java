/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.coursework.user_management.User;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aljes
 */
public class RegisterTest {
    
    

    public RegisterTest() {

    }

    

    @BeforeAll

    public static void setUpClass() {

    }

    

    @AfterAll

    public static void tearDownClass() {

    }

    

    @BeforeEach

    public void setUp() {

    }

    

    @AfterEach

    public void tearDown() {

    }





    @Test

    public void testUsername_exists() throws SQLException {

        System.out.println("Username exists");

        String username = "Aljesh";

        User user = new User();

        boolean expResult = false;

        boolean result = user.username_exists(username);

        assertEquals(expResult, result);

        

    }



    /**

     * Test of empty_fields_detected method, of class User.

     */

    @Test

    public void testEmpty_fields_detected() {

        System.out.println("Empty Fields Detected");

        User user = new User();

        
        user.setUsername("");

        user.setEmail("");

        user.setUser_birthdate("");

        user.setUser_password1("");

        user.setUser_passsword2("");

        boolean expResult = true;

        boolean result = user.empty_fields_detected();

        assertEquals(expResult, result);

        

    }



    /**

     * Test of password_mismatch method, of class User.

     */

    @Test

    public void testPassword_mismatch() {

        System.out.println("Password mismatch");

        User user = new User();

        user.setUser_password1("Aljesh");

        user.setUser_passsword2("Alijesh");

        boolean expResult = true;

        boolean result = user.password_mismatch();

        assertEquals(expResult, result);

        

    }



    /**

     * Test of adduser method, of class User.

     */

   
    

}
