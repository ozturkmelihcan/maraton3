package com.melihcanozturk.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.melihcanozturk.repository.MusteriDao;
import com.melihcanozturk.repository.SiparisDao;
import com.melihcanozturk.repository.SiparisKalemiDao;
import com.melihcanozturk.repository.UrunDao;
import com.melihcanozturk.entity.Musteri;
import com.melihcanozturk.entity.Siparis;
import com.melihcanozturk.entity.SiparisKalemii;
import com.melihcanozturk.entity.Urun;
import com.melihcanozturk.service.MusteriServicee;
import com.melihcanozturk.service.SiparisKalemiService;
import com.melihcanozturk.service.SiparisService;
import com.melihcanozturk.service.UrunService;
import com.melihcanozturk.util.HibernateUtils;

public class Main {

	public void siparisOlustur() {

	}

	public static void main(String[] args) {

	//	HibernateUtils.getSessionFactory().openSession();

		MusteriDao musteriDao = new MusteriDao();
		
		UrunDao urunDao = new UrunDao();
		
		SiparisKalemiDao siparisKalemiDao = new SiparisKalemiDao();
		
		SiparisDao siparisDao = new SiparisDao();

		MusteriServicee musteriService = new MusteriServicee();
		
		UrunService urunService = new UrunService();
		
		SiparisKalemiService siparisKalemiService = new SiparisKalemiService();
		
		SiparisService siparisService = new SiparisService();

		
		Musteri m1 = new Musteri("Ali","Kaya");
		Musteri m2 = new Musteri("Veli","Ozkan");

		musteriService.musteriOlustur(m1);
		musteriService.musteriOlustur(m2);


		Urun u1 = new Urun("Iphone 11", 17000);
		Urun u2 = new Urun("Samsung S21", 18000);
		Urun u3 = new Urun("LG LED TV", 8500);
		Urun u4 = new Urun("Arçelik Süpürge", 2500);

		urunService.urunOlustur(u1);
		urunService.urunOlustur(u2);
		urunService.urunOlustur(u3);
		urunService.urunOlustur(u4);

		SiparisKalemii sk1 = new SiparisKalemii(u1, 1);
		SiparisKalemii sk2 = new SiparisKalemii(u2, 2);
		Siparis s1 = new Siparis(m1, Arrays.asList(sk1, sk2));

		siparisDao.save(s1);

		SiparisKalemii sk3 = new SiparisKalemii(u3, 2);
		SiparisKalemii sk4 = new SiparisKalemii(u4, 3);

		Siparis s2 = new Siparis(m2, Arrays.asList(sk3, sk4));

		siparisDao.save(s2);

		SiparisKalemii sk5 = new SiparisKalemii(u1, 2);
		SiparisKalemii sk6 = new SiparisKalemii(u4, 3);

		Siparis s3 = new Siparis(m1, Arrays.asList(sk5, sk6));

		siparisDao.save(s3);

		Siparis s4 = new Siparis(m2, Arrays.asList(new SiparisKalemii(u1, 2)));
		Siparis s5 = new Siparis(m2, Arrays.asList(new SiparisKalemii(u2, 5)));

		siparisDao.save(s4);
		siparisDao.save(s5);

		// 2a çözüm
		 siparisService.siparislerinDetayiniGoster();

		 System.out.println("\n********************************************************\n");
		// 2b çözüm
		  musteriService.siparisDetayi();

		  System.out.println("\n********************************************************\n");

		  // 2c çözüm
		  siparisService.siparisAdedi();
		  
		  System.out.println("\n********************************************************\n");
		  // 2d çözüm
		  musteriService.musteriCek();
	}

}
