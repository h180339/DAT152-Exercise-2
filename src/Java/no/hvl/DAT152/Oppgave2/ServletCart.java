package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;


/**
 * A servlet that shows a web page where displaying a cart with selected coffee cups
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
@WebServlet(name = "Cart", urlPatterns = "/cart")
public class ServletCart extends HttpServlet {

	/**
	 * Shows page where displaying a cart with selected coffee cups
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String langCookie = LocaleHelper.getLang(req);
		Locale locale = req.getLocale();
		locale = LocaleHelper.setLocale(langCookie, locale, req);

		HttpSession session = req.getSession(false);
		Cart cart = (Cart) session.getAttribute("cart");

		if(cart != null && !cart.getCartList().isEmpty()) {
			req.setAttribute("cartEmpty", false);
			Cart newCart = PriceHelper.getTotals(cart, locale);
			req.setAttribute("totalCartAmount", cart.getTotalAmout());
			req.setAttribute("cart", newCart.getCartList());
		} else {
			req.setAttribute("cartEmpty", true);
		}
		//Display page.
		req.getRequestDispatcher("WEB-INF/Cart.jsp").forward(req, resp);
	}

	/**
	 * Sets the wanted language for the page
	 *
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String wantedLang = req.getParameter("Lang");
		Cookie cookie = new Cookie("lang", wantedLang);
		resp.addCookie(cookie);
		resp.sendRedirect("./cart");
	}

}
