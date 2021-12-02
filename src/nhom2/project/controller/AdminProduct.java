package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.CategoryDAO;
import nhom2.project.data.ProductDAO;
import nhom2.project.model.Category;
import nhom2.project.model.Product;

/**
 * Servlet implementation class AdminProduct
 */
@WebServlet("/AdminProduct")
public class AdminProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public AdminProduct() {
		super();
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
		int pid = Integer.parseInt(request.getParameter("pid"));
		productDAO.deleteProduct(pid);
		request.getRequestDispatcher("/admin?action=product").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String image = request.getParameter("img");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		int cid = Integer.parseInt(request.getParameter("category"));

		if (name != null && name != ""  && image != null && image != "") {
			if (description == null)
				description = "";
			if(code == null)
				code ="";
			Product product = new Product(name, price, new CategoryDAO().getCategory(cid), image, description, code);
			productDAO.saveProduct(product);
		}

//		List<Product> listProduct = new ArrayList<Product>();
//		listProduct = productDAO.getAllProduct();
//
//		request.setAttribute("listProduct", listProduct);
		request.getRequestDispatcher("/admin?action=product").forward(request, response);

	}

}
