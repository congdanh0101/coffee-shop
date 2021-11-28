package nhom2.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BillDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;

	@ManyToOne
	private Bill bill;

	@OneToOne
	private Product product;
	
	@ManyToOne
	private Size size;
	
	@ManyToOne
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

	public BillDetail() {
		super();
	}

	public BillDetail(int quantity, Bill bill, Product product, Size size, Topping topping) {
		super();
		this.quantity = quantity;
		this.bill = bill;
		this.product = product;
		this.size = size;
		this.topping = topping;
	}

	public BillDetail(int id, int quantity, Bill bill, Product product, Size size, Topping topping) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.bill = bill;
		this.product = product;
		this.size = size;
		this.topping = topping;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
