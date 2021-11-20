package nhom2.project.model;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private String code;
	public Size() {
		super();
		name="";
		code="";
	}
	public Size(int id, String name, int price,String code) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPriceCurrencyFormat() {
		Locale lc = new Locale("nv", "VN");
		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		return currency.format(price);
	}
}
