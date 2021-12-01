package nhom2.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nhom2.project.data.BillDAO;
import nhom2.project.data.BillDetailDAO;
import nhom2.project.model.Bill;
import nhom2.project.model.BillDetail;
import nhom2.project.model.Product;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/bill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillDetailDAO billdetailDAO;
	private BillDAO billDAO;
	
    public BillController() {
        super();
        billdetailDAO = new BillDetailDAO();
        billDAO = new BillDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		List<BillDetail> listBillDetail = new ArrayList<BillDetail>();
		listBillDetail = billdetailDAO.getAllBillDetailByBillID(bid);
		
		int sum = 0;
		for(int i=0;i<listBillDetail.size();i++) {
			sum +=listBillDetail.get(i).getTotal();
		}
		
		BillDetail billDetail = new BillDetail();
		String subtotal = billDetail.getTotalCurrencyFormat(sum);
		
		request.setAttribute("subtotal", subtotal);
		request.setAttribute("listBillDetail", listBillDetail);
		request.getRequestDispatcher("/admin_billdetail.jsp").forward(request, response);
		
	}

}
