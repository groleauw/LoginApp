package com.login;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
 
public class LoginDAO
{
    static Connection currentCon = null;
    static ResultSet rs = null;

    public static LoginBean login(LoginBean bean)
    {
        Statement stmt = null;
        String username = bean.getUsername();
        String password = bean.getPassword();
        String searchQuery = "select * from users where username='" + username + 
        "' AND password='" + password + "' AND isActive='1'";
 
        try
        {
            stmt=getStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean userExists = rs.next();
 
            if (!userExists)
            {
                System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
                bean.setValid(false);
            }
            else if (userExists)
            {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                System.out.println("Welcome " + firstName);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setValid(true);
            }
 
        }
        catch (Exception ex)
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }
        return bean;
    }
 
    /**
     * This method will insert the user details in the database
     */
    public static boolean doRegister(RegisterBean bean)
    {
        boolean registrationSuccess = false;
        String username = bean.getUsername();
        String password = bean.getPassword();
        String name = bean.getName();
        String lastname = bean.getLastname();
        String email = bean.getEmail();
        String dob = bean.getDob();
 
        String sql = "INSERT INTO users (uname,password,firstName,lastName,email,dob,isActive) "+
                        "Values ('"+username+"','"+password+"','"+name+"','"+lastname+"'," +
                                "'"+email+"','"+dob+"','0'); ";
 
        try
        {
            Statement stmt=getStatement();
            if(stmt.execute(sql))
            {
                System.out.println("User Registration Failed");
                registrationSuccess = false;
            }
            else {
                System.out.println("User Registration Success");
                registrationSuccess = true;
            }
        }
        catch (Exception ex)
        {
            System.out.println("Registration Exception! " + ex);
            return registrationSuccess;
        }
 
        return registrationSuccess;
    }
 
    /**
     * This method will confirm the registration by setting the isActive flag
     * for that user.
     */
    public static boolean confirmRegistration(Map<String, String> paramMap)
    {
        String sql = "UPDATE users SET isActive='1' WHERE username ='"+paramMap.get("uname")+"' AND" +
                " email ='"+paramMap.get("email")+"';";
 
        System.out.println(sql);
        try
        {
            Statement stmt=getStatement();
            if(stmt.execute(sql))
            {
                System.out.println("User Registration Confirmation Failed");
                return false;
            }
            else {
                System.out.println("User Registration Confirmation Success");
                return true;
            }
        }
        catch (Exception ex)
        {
            System.out.println("Registration Confirmation Exception! " + ex);
            return false;
        }
    }
 
    /**
     * Returns the Statement object for the connection.
     */
    private static Statement getStatement()
    {
        Statement stmt = null;
        currentCon = ConnectionManager.getConnection();
        try {
            stmt=currentCon.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE CREATING STATEMENT "+e.getMessage());
        }
        return stmt;
    }
}