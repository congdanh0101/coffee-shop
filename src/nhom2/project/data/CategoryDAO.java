package nhom2.project.data;

import nhom2.project.model.BillDetail;
import nhom2.project.model.Category;
import nhom2.project.model.Product;
import nhom2.project.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDAO {
	public Category getCategory(int ID) {
		Transaction trans = null;
		Category productType = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			trans = session.beginTransaction();
			// get an user object
			productType = session.get(Category.class, ID);
			// commit transaction
			trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return productType;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("From Category").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void saveCategory(Category category) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			ss.save(category);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void deleteCategory(int id) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			Category category = ss.get(Category.class, id);
			if (category != null) {
				List<Product> listProducts = new ArrayList<Product>();
				ProductDAO productDAO = new ProductDAO();
				listProducts = productDAO.getAllProductByCategory(id);
				for (int i = 0; i < listProducts.size(); i++) {
					List<BillDetail> billDetails = new ArrayList<BillDetail>();
					BillDetailDAO billDetailDAO = new BillDetailDAO();
					billDetails = billDetailDAO.getAllBillDetailByProductID(listProducts.get(i).getId());
					for (int j = 0; j < billDetails.size(); j++) {
						billDetailDAO.deleteBillDetail(billDetails.get(i).getId());
					}
					productDAO.deleteProduct(listProducts.get(i).getId());
				}
				String hql = "DELETE FROM Category WHERE id = :id";
				Query query = ss.createQuery(hql);
				query.setParameter("id", id);
				query.executeUpdate();
			}
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
