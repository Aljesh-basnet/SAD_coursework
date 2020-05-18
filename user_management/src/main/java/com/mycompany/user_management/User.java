
package com.mycompany.user_management;

/**
 *
 * @author abishek
 */
public class User {
    
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String email;
    protected String date_of_birth;

    public User(){}
    
    public User(int id, String firstName, String lastName, String address, String email, String date_of_birth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    public User(String firstName, String lastName, String address, String email, String date_of_birth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email=" + email + ", date_of_birth=" + date_of_birth + '}';
    }
    
    
    
}
