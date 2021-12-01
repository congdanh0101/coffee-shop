package nhom2.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
import nhom2.project.data.StatusDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.Cart;
import nhom2.project.model.Customer;
import nhom2.project.model.Status;
import nhom2.project.util.EmailUtils;

/**
 * Servlet implementation class RegisterVerify
 */
@WebServlet("/verify")
public class RegisterVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	private BillDAO billDAO;
	private String host;
    private String port;
    private String username;
    private String pass;

	public void init() {
		customerDAO = new CustomerDAO();
		billDAO = new BillDAO();ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        System.out.println(host);
        port = context.getInitParameter("port");
        System.out.println(port);
        username = "thecoffeeshop010101@gmail.com";
        System.out.println(username);
        pass = context.getInitParameter("pass");
        System.out.println(pass);
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		Cart cart = (Cart) session.getAttribute("cart");
		
		Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        System.out.println(sdf.format(dt));
        
        
        
        java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
        java.sql.Timestamp sqlTimeStamp = new Timestamp(dt.getTime());
        
        System.out.println(sqlDate);
        System.out.println(sqlTimeStamp.getHours());
        
        
		String code = request.getParameter("authcode");

		if (code.equals(customer.getCode())) {
			customerDAO.saveCustomer(customer);
			Bill bill = new Bill();
			bill.setCustomer(customer);
			bill.setDate(sqlDate);
			bill.setTime(sqlTimeStamp);
			bill.setStatus(new StatusDAO().getStatus(1));
			billDAO.saveBill(bill);
			cart.insertBillDetail(bill);
		
			session.setAttribute("newCustomer", customer);
		}
		response.sendRedirect("result.jsp");
		session.invalidate();
	}

}
