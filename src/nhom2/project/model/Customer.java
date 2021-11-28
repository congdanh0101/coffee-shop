package nhom2.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String code;
	private String phone;
	private String address;
	private String comment;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private Bill bill;

	public Customer() {
		super();
		name = "";
		email = "";
		code = "";
		phone = "";
		address = "";
		comment = "";
	}

	public Customer(String name, String email, String code, String phone, String address,String comment) {
		super();
		this.name = name;
		this.email = email;
		this.code = code;
		this.phone = phone;
		this.address = address;
		this.comment = comment;
	}

	public Customer(int id, String name, String email, String code, String phone, String address,String comment) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.code = code;
		this.phone = phone;
		this.address = address;
		this.comment = comment;
	}
	
	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
