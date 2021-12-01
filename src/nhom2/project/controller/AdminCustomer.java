package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.CustomerDAO;
import nhom2.project.model.Customer;
import nhom2.project.util.HibernateUtil;

/**
 * Servlet implementation class AdminCustomer
 */
@WebServlet("/AdminCustomer")
public class AdminCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
    public AdminCustomer() {
        super();
        customerDAO = new CustomerDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Customer> listCustomers = new ArrayList<Customer>();
		listCustomers = HibernateUtil.getSessionFactory().openSession().createQuery("FROM Customer WHERE id = ?1").setInteger(1, cid).getResultList();
		request.setAttribute("listCustomer", listCustomers);
		request.getRequestDispatcher("/admin_customer.jsp").forward(request, response);
	}

}
