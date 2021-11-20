package nhom2.project.model;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private int price;
	private String description;
	private String image;
	private String code;
	
	@ManyToOne
	private Category category;

	public Product() {
		super();
		name = "";
		description="";
		image="";
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Product(int id, String name, int price, String description, Category category, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image=image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPriceCurrencyFormat() {
		Locale lc = new Locale("nv", "VN");
		NumberFormat currency = NumberFormat.getCurrencyInstance(lc);
		return currency.format(price);
	}
}
