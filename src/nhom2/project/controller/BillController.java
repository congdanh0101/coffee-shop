package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.BillDetailDAO;
import nhom2.project.model.BillDetail;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/bill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillDetailDAO billdetailDAO;
	
	
    public BillController() {
        super();
        billdetailDAO = new BillDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		List<BillDetail> listBillDetail = new ArrayList<BillDetail>();
		listBillDetail = billdetailDAO.getAllBillDetailByBillID(bid);
		request.setAttribute("listBillDetail", listBillDetail);
		request.getRequestDispatcher("/admin_billdetail.jsp").forward(request, response);
		
	}

}
