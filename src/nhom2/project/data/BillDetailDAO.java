package nhom2.project.data;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.BillDetail;
import nhom2.project.util.HibernateUtil;

public class BillDetailDAO {
	public void saveBillDetail(BillDetail billDetail) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			ss.save(billDetail);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void deleteBillDetail(int id) {
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			BillDetail billDetail = ss.get(BillDetail.class, id);
			if (billDetail != null) {
				String hql = "DELETE BillDetail WHERE id = :id";
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

	public BillDetail getBillDetail(int id) {
		Transaction trans = null;
		BillDetail billDetail = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			billDetail = ss.get(BillDetail.class, id);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}

		return billDetail;
	}

	@SuppressWarnings("unchecked")
	public List<BillDetail> getAllBillDetail() {
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("FROM BillDetail").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<BillDetail> getAllBillDetailByBillID(int id) {
		try {
			return HibernateUtil.getSessionFactory().openSession()
					.createQuery("FROM BillDetail AS BD WHERE BD.bill = ?1").setInteger(1, id).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<BillDetail> getAllBillDetailByProductID(int id) {
		try {
			return HibernateUtil.getSessionFactory().openSession()
					.createQuery("FROM BillDetail AS BD WHERE BD.product = ?1").setInteger(1, id).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}
