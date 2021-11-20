package nhom2.project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.*;
import nhom2.project.util.HibernateUtil;

public class SizeDAO {
	public Size getSize(int id) {
		Size size = null;
		Transaction trans = null;
		try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
			trans = ss.beginTransaction();
			size = ss.get(Size.class, id);
			trans.commit();
		} catch (Exception e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public List<Size> getAllSize(){
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("From Size").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
		
	}
}
