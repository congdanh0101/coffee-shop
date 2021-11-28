package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.CategoryDAO;
import nhom2.project.data.ProductDAO;
import nhom2.project.model.Category;
import nhom2.project.model.Product;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	
	public HomeController() {
		categoryDAO = new CategoryDAO();
		productDAO = new ProductDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<Category> listCategory = new ArrayList<Category>();
		listCategory = categoryDAO.getAllCategory();
		
		List<Product> listProduct = new ArrayList<Product>();
		listProduct = productDAO.getAllProduct();
		
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("listCategory", listCategory);
		RequestDispatcher rd = req.getRequestDispatcher("shop.jsp");
		rd.forward(req, resp);
	}
}
