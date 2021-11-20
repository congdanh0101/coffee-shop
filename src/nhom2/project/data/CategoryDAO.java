package nhom2.project.data;
import nhom2.project.model.Category;
import nhom2.project.util.HibernateUtil;

import java.util.List;

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
	public List<Category> getAllCategory(){
		try {
        	return HibernateUtil.getSessionFactory().openSession().createQuery("From Category").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}
