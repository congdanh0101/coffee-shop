package nhom2.project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.Status;
import nhom2.project.util.HibernateUtil;

public class StatusDAO {
	public Status getStatus(int id) {
		Transaction trans = null;
		Status status = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			status = ss.get(Status.class, id);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}
	
	@SuppressWarnings("unchecked")
	public List<Status> getAllStatus(){
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("FROM Status").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return null;
	}
}
