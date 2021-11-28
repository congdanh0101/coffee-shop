package nhom2.project.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class LineItem implements Serializable{
	private Product product;
	private Size size;
	private Topping topping;
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	private int quantity;
	
	public LineItem() {}
	
	public void setProduct(Product p) {
		this.product = p;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getPrice() {
		return product.getPrice() + size.getPrice() + topping.getPrice();
	}
	
	public int getTotal() {
		return quantity * getPrice();
	}
	
	public String getPriceCurrencyFormat() {
//		Locale lc = new Locale("nv", "VN");
//		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(this.getPrice()) + " VNĐ";
//		return currency.format(this.getPrice());
	}
	
	public String getTotalCurrencyFormat() {
//		Locale lc = new Locale("nv", "VN");
//		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		DecimalFormat currency = new DecimalFormat("###,###,###");
		return currency.format(this.getTotal()) + " VNĐ";
	}
}
