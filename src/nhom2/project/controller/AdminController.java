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

import nhom2.project.data.BillDAO;
import nhom2.project.data.BillDetailDAO;
import nhom2.project.data.CategoryDAO;
import nhom2.project.data.CustomerDAO;
import nhom2.project.data.ProductDAO;
import nhom2.project.data.StatusDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.BillDetail;
import nhom2.project.model.Cart;
import nhom2.project.model.Category;
import nhom2.project.model.Customer;
import nhom2.project.model.Product;
import nhom2.project.model.Status;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillDAO billDAO;
	private CustomerDAO customerDAO;
	private BillDetailDAO billdetailDAO;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	private StatusDAO statusDAO;

	public AdminController() {
		super();
		billDAO = new BillDAO();
		customerDAO = new CustomerDAO();
		billdetailDAO = new BillDetailDAO();
		productDAO = new ProductDAO();
		categoryDAO = new CategoryDAO();
		statusDAO = new StatusDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// Get action
		String action = request.getParameter("action");
		String url = "";
		ServletContext sc = request.getServletContext();
		if (action != null && action != "") {
			String[] actions = { "customer", "product", "bill", "category", "billdetail" };
			for (int i = 0; i < actions.length; i++) {
				if (action.equals(actions[i])) {
					url = "/admin_" + actions[i] + ".jsp";
					break;
				}
			}
		}
		String name = request.getParameter("category");
		if (name != null && name != "") {
			saveCate(name);
			url = "/admin_category.jsp";
		}

		List<Bill> listBill = new ArrayList<Bill>();
		listBill = billDAO.getAllBill();

		List<Product> listProduct = new ArrayList<Product>();
		listProduct = productDAO.getAllProduct();

		List<Category> listCategory = new ArrayList<Category>();
		listCategory = categoryDAO.getAllCategory();

		List<Customer> listCustomer = new ArrayList<Customer>();
		listCustomer = customerDAO.getAllCustomer();

		List<BillDetail> listBillDetail = new ArrayList<BillDetail>();
		listBillDetail = billdetailDAO.getAllBillDetail();

		List<Status> listStatus = new ArrayList<Status>();
		listStatus = statusDAO.getAllStatus();

		request.setAttribute("listBill", listBill);
		request.setAttribute("listStatus", listStatus);
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listProduct", listProduct);
		sc.getRequestDispatcher(url).forward(request, response);
	}

	public void saveCate(String name) {
		Category category = new Category();
		category.setName(name);
		categoryDAO.saveCategory(category);

	}
}
