package nhom2.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;

	@Temporal(TemporalType.TIME)
	private Date time;

	@OneToOne
	private Customer customer;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bill")
	private List<BillDetail> listBillDetail;


	public Bill() {
		super();
	}

	public Bill(Date date, Date time, Customer customer) {
		super();
		this.date = date;
		this.time = time;
		this.customer = customer;


	}

	public Bill(int id, Date date, Date time, Customer customer) {
		super();
		this.id = id;
		this.time = time;
		this.date = date;
		this.customer = customer;

	}
	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BillDetail> getListBillDetail() {
		return listBillDetail;
	}

	public void setListBillDetail(List<BillDetail> listBillDetail) {
		this.listBillDetail = listBillDetail;
	}

	

}
