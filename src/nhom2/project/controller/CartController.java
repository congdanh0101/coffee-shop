package nhom2.project.controller;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.ProductDAO;
import nhom2.project.data.SizeDAO;
import nhom2.project.data.ToppingDAO;
import nhom2.project.model.Cart;
import nhom2.project.model.LineItem;
import nhom2.project.model.Product;
import nhom2.project.model.Size;
import nhom2.project.model.Topping;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private SizeDAO sizeDAO;
	private ToppingDAO toppingDAO;
	
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO = new ProductDAO();
        sizeDAO = new SizeDAO();
        toppingDAO = new ToppingDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();
       
        String productId = request.getParameter("productId");
        String sizeId = request.getParameter("size");
        System.out.println(sizeId);
        String toppingId= request.getParameter("topping");
        System.out.println(toppingId);
        String quantityString = request.getParameter("quantity");

        HttpSession session = request.getSession(false);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        
        //if the user enters a negative or invalid quantity,
        //the quantity is automatically reset to 1.
        int quantity;
        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                quantity = 1;
            }
        } catch (NumberFormatException nfe) {
            quantity = 1;
        }

        // String path = sc.getRealPath("/WEB-INF/products.txt");
        // Product product = ProductIO.getProduct(productCode, path);
        
        // JDBC
        Product product = null;
        Size size = null;
        Topping topping =null;
		product = productDAO.getProduct(Integer.parseInt(productId));
		topping = toppingDAO.getTopping(Integer.parseInt(toppingId));
        size = sizeDAO.getSize(Integer.parseInt(sizeId));

        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setSize(size);
        lineItem.setTopping(topping);
        lineItem.setQuantity(quantity);
        if (quantity > 0) {
            cart.addItem(lineItem);
        } else if (quantity == 0) {
            cart.removeItem(lineItem);
        }
        session.setAttribute("cart", cart);

        sc.getRequestDispatcher("/cart.jsp")
                .forward(request, response);
	}

}
