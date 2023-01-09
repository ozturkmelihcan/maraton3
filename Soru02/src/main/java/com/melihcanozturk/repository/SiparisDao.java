package com.melihcanozturk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.melihcanozturk.entity.Siparis;
import com.melihcanozturk.entity.Urun;
import com.melihcanozturk.util.HibernateUtils;

public class SiparisDao implements ICrud<Siparis> {
	private Session session;
	private Transaction transaction;

	@Override
	public void save(Siparis t) {
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
	public void update(Siparis t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.merge(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Update siparis patladık");
			if (transaction == null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void delete(long id) {
		Session session = null;
		try {
			Siparis siparis = findById(id);
			if (siparis != null) {
				session = HibernateUtils.getSessionFactory().openSession();
				session.getTransaction().begin();
				session.delete(siparis);
				session.getTransaction().commit();
				System.out.println("siparis data is delete to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete siparis to DB");
		} finally {
			session.close();
		}

	}

	@Override
	public Siparis findById(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Siparis siparis;

		try {
			siparis = session.find(Siparis.class, id);
			if (siparis != null) {

				System.out.println("siparis Found-->" + siparis);
				return siparis;
			} else {
				System.out.println("siparis not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding siparis to DB");
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Siparis> listAll() {
		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Siparis> userQuery = session.createQuery("from Siparis", Siparis.class);
		List<Siparis> siparisler = userQuery.getResultList();
		return siparisler;
	}
	
	public void SiparisAdedi() {
        Session session = null;
        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        List<Object[]> list = entityManager
                .createNativeQuery("select musteri_id,count(*) from siparis group by musteri_id").getResultList();

        for (Object[] element : list) {
            System.out.println("Müşteri ID: " + element[0] + " Sipariş Sayısı:" + element[1]);
        }
    }
	
	

}
