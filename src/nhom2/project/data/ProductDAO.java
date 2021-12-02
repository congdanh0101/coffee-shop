package nhom2.project.data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.Transaction;

import nhom2.project.model.BillDetail;
import nhom2.project.model.Product;
import nhom2.project.util.HibernateUtil;

public class ProductDAO {
	// init
	Connection conn;

	// Constructor
	public Product getProduct(int ID) {
		Transaction trans = null;
		Product product = null;

		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			product = ss.get(Product.class, ID);
			trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("FROM Product").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Product> getAllProductByCategory(int cid) {
//		List<Product> result = new ArrayList<Product>();
//		Transaction trans = null;
//		try {
//			conn = MySQLConnectionUtils.getConnection();
//			String sql = "SELECT * FROM learningtools.product\r\n"
//					+ "where category_id =  " + cid;
//			Statement smtm = conn.createStatement();
//			ResultSet rs = smtm.executeQuery(sql);
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String description = rs.getString(2);
//				String img = rs.getString(3);
//				String name = rs.getString(4);
//				int price = rs.getInt(5);
//				Category cate = new Category();
//				cate.setId(rs.getInt(6));
//				result.add(new Product(id,name,price,description,cate,img));
//			}
//			rs.close();
//			smtm.close();
//			MySQLConnectionUtils.disconnectMySQL(conn);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}

		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			return ss.createQuery("FROM Product AS P WHERE P.category = ?1").setInteger(1, cid).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;
	}

	public void saveProduct(Product product) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			ss.save(product);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void deleteProduct(int id) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			Product product = ss.get(Product.class, id);
			if (product != null) {
				List<BillDetail> billDetails = new ArrayList<BillDetail>();
				BillDetailDAO billDetailDAO = new BillDetailDAO();
				billDetails = billDetailDAO.getAllBillDetailByProductID(product.getId());
				for (int i = 0; i < billDetails.size(); i++) {
					billDetailDAO.deleteBillDetail(billDetails.get(i).getId());
				}
//				String hql = "DELETE FROM Product WHERE id = :id";
//				Query query = ss.createQuery(hql);
//				query.setParameter("id", id);
//				query.executeUpdate();
				
				ss.createQuery("DELETE FROM Product WHERE id = :id").setParameter("id", id).executeUpdate();
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
