package nhom2.project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nhom2.project.model.Topping;
import nhom2.project.util.HibernateUtil;

public class ToppingDAO {
	
	public Topping getTopping(int id) {
		Topping topping =null;
		Transaction trans = null;
		try(Session ss = HibernateUtil.getSessionFactory().openSession()){
			trans = ss.beginTransaction();
			topping = ss.find(Topping.class, id);
			trans.commit();
		}catch (Exception e) {
			if(trans!=null)trans.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return topping;
	}
	
	@SuppressWarnings("unchecked")
	public List<Topping> gettAllTopping(){
		try {
			return HibernateUtil.getSessionFactory().openSession().createQuery("From Topping").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}
