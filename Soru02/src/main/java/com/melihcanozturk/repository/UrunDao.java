package com.melihcanozturk.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.melihcanozturk.entity.Musteri;
import com.melihcanozturk.entity.Urun;
import com.melihcanozturk.util.HibernateUtils;

public class UrunDao implements ICrud<Urun> {
	private Session session;
	private Transaction transaction;

	@Override
	public void save(Urun t) {
		try (Session session = dataBaseConnectionHibernate()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();

		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void update(Urun t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.merge(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Update urun patladık");
			if (transaction == null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Urun urun = findById(id);
			if (urun != null) {
				session = HibernateUtils.getSessionFactory().openSession();
				session.getTransaction().begin();
				session.delete(urun);
				session.getTransaction().commit();
				System.out.println("urun data is delete to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete urun to DB");
		} finally {
			session.close();
		}

	}

	@Override
	public Urun findById(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Urun urun;

		try {
			urun = session.find(Urun.class, id);
			if (urun != null) {

				System.out.println("urun Found-->" + urun);
				return urun;
			} else {
				System.out.println("urun not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding urun to DB");
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Urun> listAll() {
		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Urun> userQuery = session.createQuery("from Urun", Urun.class);
		List<Urun> urunler = userQuery.getResultList();
		return urunler;
	}

}
