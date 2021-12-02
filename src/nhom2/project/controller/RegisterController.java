package nhom2.project.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nhom2.project.model.Customer;
import nhom2.project.util.EmailUtils;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String host;
    private String port;
    private String username;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
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
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     // reads form fields
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String comment = request.getParameter("comment"); 
        if(comment == null)comment = "";

        String code = EmailUtils.getRandom();
        
      //create new user using all information
        Customer customer = new Customer(name,email,code,phone,address,comment);
        
        //call the send email method
        boolean test;
		try {
			test = EmailUtils.sendEmail(host, port, username, pass, email, "Email Verification",
					"Registered successfully.Please verify your account using this code: " + customer.getCode());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test = false;
		}
		
		System.out.println(test);
        
   		//check if the email send successfully
        if(test){
            HttpSession session  = request.getSession();
            session.setAttribute("customer", customer);
            response.sendRedirect("verify.jsp");
        } 
	}

}
