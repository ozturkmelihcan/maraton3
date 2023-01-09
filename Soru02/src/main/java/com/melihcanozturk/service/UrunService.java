package com.melihcanozturk.service;


import com.melihcanozturk.repository.UrunDao;
import com.melihcanozturk.entity.Urun;


public class UrunService {

private UrunDao urunDao = new UrunDao();
	
	
public void urunOlustur(Urun u) {
		urunDao.save(u);	
	}
	
}
