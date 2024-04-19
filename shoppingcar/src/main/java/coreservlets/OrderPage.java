package coreservlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/OrderPage")
public class OrderPage extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    ShoppingCart cart;
    synchronized(session) {
      cart = (ShoppingCart)session.getAttribute("shoppingCart");
      
      if (cart == null) {
        cart = new ShoppingCart();
        session.setAttribute("shoppingCart", cart);
      }
      String itemID = request.getParameter("itemID");
      if (itemID != null) {
        String numItemsString = request.getParameter("numItems");
        if (numItemsString == null) {
          cart.addItem(itemID);
        } else {
          
          int numItems;
          try {
            numItems = Integer.parseInt(numItemsString);
          } catch (NumberFormatException nfe) {
            numItems = 1;
          }
          cart.setNumOrdered(itemID, numItems);
        }
      }
    }
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Sipariş Durumu";
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
    synchronized(session) {
      List itemsOrdered = cart.getItemsOrdered();
      if (itemsOrdered.size() == 0) {
        out.println("<H2><I>Sepetinizde öğe bulunmamaktadır...</I></H2>");
      } else {
        
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                    "<TR BGCOLOR=\"#FFAD00\">\n" +
                    "<TH>Öğe ID<TH>Açıklama\n" +
                    "<TH>Birim Maliyet<TH>Sayı<TH>Toplam Maliyet");
        ItemOrder order;
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
          order = (ItemOrder)itemsOrdered.get(i);
          out.println("<TR>\n" +
                      "<TD>" + order.getItemID() + "\n" +
                      "<TD>" + order.getShortDescription() + "\n" +
                      "<TD>" +
                      formatter.format(order.getUnitCost()) + "\n" +
                      "<TD>" +
                      "<FORM>\n" + 
                      "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
                      " VALUE=\"" + order.getItemID() + "\">\n" +
                      "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
                      " SIZE=3 VALUE=\"" +
                      order.getNumItems() + "\">\n" +
                      "<SMALL>\n" +
                      "<INPUT TYPE=\"SUBMIT\"\n " +
                      " VALUE=\"Siparişi Güncelle\">\n" +
                      "</SMALL>\n" +
                      "</FORM>\n" +
                      "<TD>" +
                      formatter.format(order.getTotalCost()));
        }
        String checkoutURL = response.encodeURL("../Checkout.html");
        
        out.println("</TABLE>\n" +
                    "<FORM ACTION=\"" + checkoutURL + "\">\n" +
                    "<BIG><CENTER>\n" +
                    "<INPUT TYPE=\"SUBMIT\"\n" +
                    " VALUE=\"Ödemeye İlerle\">\n" +
                    "</CENTER></BIG></FORM>");
      }
      out.println("</BODY></HTML>");
    }
  }
}
