package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.ProductDAO;
import nhom2.project.model.Cart;
import nhom2.project.model.LineItem;
import nhom2.project.model.Product;



@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
	private ProductDAO productDAO;

    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO = new ProductDAO();
    }
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext(); 
        HttpSession session = req.getSession();
        
        
        sc.getRequestDispatcher("/checkout.jsp").forward(req, resp);
       
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
