package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.SeccionSubte;

public class SeccionSubteDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(SeccionSubte objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}

	public void actualizar(SeccionSubte objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

	public void eliminar(SeccionSubte objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}

	public SeccionSubte traerSeccionSubte(long idSeccionSubte) throws HibernateException {
		SeccionSubte objeto = null;
		try {
			iniciaOperacion();
			objeto = (SeccionSubte) session.get(SeccionSubte.class, idSeccionSubte);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	public SeccionSubte traerSeccionSubte (int cantidadDeViajes) throws HibernateException{
		SeccionSubte objeto= null;
		long id=1;
		if(cantidadDeViajes>0&&cantidadDeViajes<21) {
			id=1;
		}else if(cantidadDeViajes>20&&cantidadDeViajes<31) {
			id=2; 
		}
		if(cantidadDeViajes>30&&cantidadDeViajes<41) {
			id=3;
		}
		if(cantidadDeViajes>41) {
			id=4;
		}
		try {
			iniciaOperacion();
			objeto = (SeccionSubte) session.get(SeccionSubte.class, id);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
}
