package nhom2.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.data.BillDAO;
import nhom2.project.data.CustomerDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.Cart;
import nhom2.project.model.Customer;

/**
 * Servlet implementation class RegisterVerify
 */
@WebServlet("/verify")
public class RegisterVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	private BillDAO billDAO;

	public void init() {
		customerDAO = new CustomerDAO();
		billDAO = new BillDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterVerify() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		
		Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(dt));
        
        java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
        
		String code = request.getParameter("authcode");

		if (code.equals(customer.getCode())) {
			customerDAO.saveCustomer(customer);
			Bill bill = new Bill();
			bill.setCustomer(customer);
			bill.setDate(sqlDate);
			billDAO.saveBill(bill);
			session.setAttribute("newCustomer", customer);
			response.sendRedirect("result.jsp");
		} else {
			
		}
	}

}
