package coreservlets;
/** A specialization of the CatalogPage servlet that
* displays a page selling two famous computer books.
* Orders are sent to the OrderPage servlet.
*/
import javax.servlet.annotation.WebServlet;

@WebServlet("/TechBooksPage")
public class TechBooksPage extends CatalogPage {
  public void init() {
	String[] ids = { "hall001", "hall002" };
	setItems(ids);
	setTitle("All-Time Best Computer Books");
	}
}
