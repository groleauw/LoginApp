package com.login;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            System.out.println("In the Login Servlet");
            RegisterBean register = new RegisterBean();
            /* Please note that the value in the getParameter() should be same as the the value of
             * attribute "name" on the register.jsp page. 
             * This will take the value inserted on JSP page and set the same in the bean 
             */
            register.setUsername(request.getParameter("username"));
            register.setPassword(request.getParameter("password"));
            register.setName(request.getParameter("name"));
            register.setLastname(request.getParameter("lastname"));
            register.setEmail(request.getParameter("email"));
            register.setDob(request.getParameter("dob"));
 
            //inserting the user details in the DB
            boolean success = LoginDAO.doRegister(register);
 
            if(success)
            {
                System.out.println("Need to send the confirmation mail to the Email");
                RegistrationEmail mail = new RegistrationEmail();
                System.out.println("Sending Registration mail");
                mail.sendRegistrationMail(register);
                response.sendRedirect("LoginPage.jsp");
            }
            else
            {
                System.out.println("Register Again");
            }
 
        } catch (Throwable exc)
        {
            System.out.println(exc);
        }
    }
 
}
