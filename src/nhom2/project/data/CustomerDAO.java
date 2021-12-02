package nhom2.project.data;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.Customer;
import nhom2.project.util.HibernateUtil;

public class CustomerDAO {
	public void saveCustomer(Customer customer) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			ss.save(customer);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void deleteCustomer(int id) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			Customer customer = ss.get(Customer.class, id);
			if (customer != null) {
//				String hql = "DELETE FROM Customer WHERE id = :id";
//				Query query = ss.createQuery(hql);
//				query.setParameter("id", id);
//				query.executeUpdate();
				
				ss.createQuery("DELETE FROM Customer WHERE id = :id").setParameter("id", id).executeUpdate();
			}
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("FROM Customer").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public Customer getCustomer(int id) {
		Transaction trans = null;
		Customer customer = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			customer = ss.get(Customer.class, id);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return customer;
	}
}
