package com.login;
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ConfirmRegistration() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getQueryString());
        Map<String, String> paramMap = ConfirmRegistration.getQueryParams(request.getQueryString());
        boolean confirmSuccess = LoginDAO.confirmRegistration(paramMap);
        HttpSession session = request.getSession(true);
        session.setAttribute("user",paramMap.get("user"));
        session.setAttribute("email",paramMap.get("email"));
        if(confirmSuccess){
            response.sendRedirect("RegistrationConfirmation.jsp");}
        else
        {
            System.out.println("Regisrtation Confirmation Failed");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
 
    /**
     * This method will return the number of parameters in the request url with its values 
     */
    private static Map<String, String> getQueryParams(String query) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            if (query.length() > 1) {
                for (String param : query.split("&")) 
                {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    params.put(key, value);
                }
            }
 
            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }
 
}
