package com.melihcanozturk.service;

import com.melihcanozturk.repository.SiparisKalemiDao;
import com.melihcanozturk.entity.SiparisKalemii;


public class SiparisKalemiService {

	
	private SiparisKalemiDao siparisKalemiDao = new SiparisKalemiDao();
	
	public void siparisKalemiOlustur(SiparisKalemii siparisKalemi) {
		
		siparisKalemiDao.save(siparisKalemi);
	}
	
}
