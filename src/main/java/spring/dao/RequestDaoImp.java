package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Number;

/**
 * @author Piyush
 *
 */
@Repository
public class RequestDaoImp implements RequestDao {
	Session session;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long getRequestCount() {
		long res = 0;
		Session ses = null;
		try {
			ses = sessionFactory.getCurrentSession();

			Number db = ses.find(Number.class, 1);

			if (db != null) {
				res = db.getCount();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void setRequestCount() {
		Session ses = null;
		try {
			ses = sessionFactory.getCurrentSession();

			int updated = ses.createQuery("update Number d set d.count=d.count+1 where d.id=1").executeUpdate();

			if (updated == 0) {
				Number db = new Number();
				db.setCount(1);
				ses.save(db);

			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void resetcount() {
		Session ses = null;
		try {
			ses = sessionFactory.getCurrentSession();

			ses.createQuery("update Number d set d.count=0 where d.id=1").executeUpdate();

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
