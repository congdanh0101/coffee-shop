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

@WebServlet({ "/category", "/categoryadmin" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO pdDAO;
	private CategoryDAO cateDAO;

	public CategoryController() {
		super();
		pdDAO = new ProductDAO();
		cateDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));

		String url = request.getRequestURI();
		System.out.println(url);

		List<Product> listProductByCategory = new ArrayList<Product>();
		listProductByCategory = pdDAO.getAllProductByCategory(cid);

		List<Category> listCategory = cateDAO.getAllCategory();

		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listProduct", listProductByCategory);
		if (url.contains("admin")) {
			request.getRequestDispatcher("admin_product.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("shop.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
