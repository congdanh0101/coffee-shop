package nhom2.project.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import nhom2.project.data.BillDetailDAO;

public class Cart implements Serializable {
	private ArrayList<LineItem> items;

	public Cart() {
		items = new ArrayList<LineItem>();
	}

	public ArrayList<LineItem> getItems() {
		return items;
	}

	public int getCount() {
		return items.size();
	}

	public void addItem(LineItem item) {
		String codeProduct = item.getProduct().getCode();
		String codeSize = item.getSize().getCode();
		String codeTopping = item.getTopping().getCode();
		int quantity = item.getQuantity();
		for (int i = 0; i < items.size(); i++) {
			LineItem lineItem = items.get(i);
			if (lineItem.getProduct().getCode().equals(codeProduct) && lineItem.getSize().getCode().equals(codeSize)
					&& lineItem.getTopping().getCode().equals(codeTopping)) {
				lineItem.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}

	public void removeItem(LineItem item) {
		String codeProduct = item.getProduct().getCode();
		String codeSize = item.getSize().getCode();
		String codeTopping = item.getTopping().getCode();
		for (int i = 0; i < items.size(); i++) {
			LineItem lineItem = items.get(i);
			if (lineItem.getProduct().getCode().equals(codeProduct) && lineItem.getSize().getCode().equals(codeSize)
					&& lineItem.getTopping().getCode().equals(codeTopping)) {
				items.remove(i);
				return;
			}
		}
	}

	public int getSubTotal() {
		int total = 0;
		for (int i = 0; i < items.size(); i++) {
			LineItem item = items.get(i);
			total = total + item.getTotal();
		}
		return total;
	}

	public String getSubTotalCurrencyFormat() {
//    	Locale lc = new Locale("nv", "VN");
//		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(this.getSubTotal()) + " VNĐ";
	}

	public void insertBillDetail(Bill bill) {
		for (int i = 0; i < items.size(); i++) {
			LineItem item = items.get(i);
			BillDetail billdetail = new BillDetail();
			billdetail.setProduct(item.getProduct());
			billdetail.setQuantity(item.getQuantity());
			billdetail.setSize(item.getSize());
			billdetail.setTopping(item.getTopping());
			billdetail.setBill(bill);
			billdetail.setPrice(item.getPrice());
			billdetail.setTotal(item.getTotal());
			BillDetailDAO billdetailDAO = new BillDetailDAO();
			billdetailDAO.saveBillDetail(billdetail);
		}
	}
}
