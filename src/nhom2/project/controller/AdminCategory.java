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
@WebServlet("/AdminCategory")
public class AdminCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;

	public AdminCategory() {
		super();
		categoryDAO = new CategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doPost(request, response);
		int cid = Integer.parseInt(request.getParameter("cid"));
		categoryDAO.deleteCategory(cid);
		request.getRequestDispatcher("/admin?action=category").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		if (category != null && category != "") {
			Category cate = new Category(category);
			categoryDAO.saveCategory(cate);
		}

		request.getRequestDispatcher("/admin?action=category").forward(request, response);

	}

}
