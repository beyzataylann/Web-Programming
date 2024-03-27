import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Form verilerini al
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String eposta = request.getParameter("eposta");
        String sifre = request.getParameter("sifre");

        // Form verilerini ekrana yazdır
        out.println("<html><head><title>Kayıt Bilgileri</title></head><body>");
        out.println("<h2>Kayıt Bilgileri:</h2>");
        out.println("<p>Ad: " + ad + "</p>");
        out.println("<p>Soyad: " + soyad + "</p>");
        out.println("<p>E-Posta: " + eposta + "</p>");
        out.println("<p>Şifre: *********</p>"); // Şifre maskelenmiş şekilde yazdırılıyor
        out.println("</body></html>");

        // Tarayıcı modelini JavaScript mesaj kutusu olarak göster
        String userAgent = request.getHeader("User-Agent");
        out.println("<script>alert('Tarayıcı Modeli: " + userAgent + "');</script>");
    }
}