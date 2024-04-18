package log.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistartionServlet")
public class RegistartionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        boolean remember = "on".equals(rememberMe);

        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            if (remember) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(30 * 24 * 60 * 60); 
                response.addCookie(cookie);
            }

            response.sendRedirect("home.jsp");
        } 
        else {
            response.sendRedirect("login.jsp");
        }
    }

    private boolean authenticate(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}
