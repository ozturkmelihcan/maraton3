package com.melihcanozturk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.melihcanozturk.entity.Musteri;
import com.melihcanozturk.entity.SiparisKalemii;
import com.melihcanozturk.util.HibernateUtils;

public class SiparisKalemiDao implements ICrud<SiparisKalemii> {
	private Session session;
	private Transaction transaction;

	@Override
	public void save(SiparisKalemii t) {
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
	public void update(SiparisKalemii t) {
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
			SiparisKalemii siparisKalemi = findById(id);
			if (siparisKalemi != null) {
				session = HibernateUtils.getSessionFactory().openSession();
				session.getTransaction().begin();
				session.delete(siparisKalemi);
				session.getTransaction().commit();
				System.out.println("siparisKalemi data is delete to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while delete siparisKalemi to DB");
		} finally {
			session.close();
		}

	}

	@Override
	public SiparisKalemii findById(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		SiparisKalemii siparisKalemi;

		try {
			siparisKalemi = session.find(SiparisKalemii.class, id);
			if (siparisKalemi != null) {

				System.out.println("siparisKalemi Found-->" + siparisKalemi);
				return siparisKalemi;
			} else {
				System.out.println("siparisKalemi not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding siparisKalemi to DB");
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<SiparisKalemii> listAll() {
		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<SiparisKalemii> userQuery = session.createQuery("from SiparisKalemi", SiparisKalemii.class);
		List<SiparisKalemii> siparisKalemi = userQuery.getResultList();
		return siparisKalemi;
	}

	public void musteriSiparisAdedi() {
		EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		List<Object[]> list = entityManager.createNativeQuery("select id, sipariskalemi.adet from sipariskalemi ")
				.getResultList();
		for (Object[] element : list) {
			System.out.println("müşteri ID: " + element[0] + " Siparis sayısı: " + element[1]);
		}

	}
}
