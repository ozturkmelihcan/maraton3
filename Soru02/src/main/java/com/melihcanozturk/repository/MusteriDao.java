package com.melihcanozturk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.melihcanozturk.entity.Musteri;
import com.melihcanozturk.util.HibernateUtils;

public class MusteriDao implements ICrud<Musteri> {
	private Session session;
	private Transaction transaction;

	@Override
	public void save(Musteri t) {
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
	public void update(Musteri t) {

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.merge(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Update sinif patladık");
			if (transaction == null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Musteri musteri = findById(id);
			if (musteri != null) {
				session = HibernateUtils.getSessionFactory().openSession();
				session.getTransaction().begin();
				session.delete(musteri);
				session.getTransaction().commit();
				System.out.println("Musteri data is delete to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete musteri to DB");
		} finally {
			session.close();
		}

	}

	@Override
	public Musteri findById(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Musteri musteri;

		try {
			musteri = session.find(Musteri.class, id);
			if (musteri != null) {

				System.out.println("musteri Found-->" + musteri);
				return musteri;
			} else {
				System.out.println("musteri not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding musteri to DB");
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Musteri> listAll() {
		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Musteri> userQuery = session.createQuery("from Musteri", Musteri.class);
		List<Musteri> musteriler = userQuery.getResultList();
		return musteriler;
	}

	 public void siparisIDyegoremustericek() {
	        Session session = null;
	        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
	        List<Object[]> list = entityManager
	                .createNativeQuery("select musteri.ad , musteri.soyad, siparis.id from musteri \r\n"
	                        + "inner join siparis on musteri.id= siparis.musteri_id ").getResultList();

	        for (Object[] element : list) {
	            System.out.println("Müşteri Ad: " + element[0] + " ,Müşteri Soyad:" + element[1]+ " ,Sipariş Id:"+ element[2]);
	        }
	    }
}
