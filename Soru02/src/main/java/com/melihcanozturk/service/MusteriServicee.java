package com.melihcanozturk.service;

import java.util.List;

import com.melihcanozturk.repository.MusteriDao;
import com.melihcanozturk.entity.Musteri;
import com.melihcanozturk.entity.Siparis;
import com.melihcanozturk.entity.SiparisKalemii;

public class MusteriServicee {

	private MusteriDao musteriDao = new MusteriDao();

	public void musteriOlustur(Musteri m) {
		musteriDao.save(m);
	}

	public void siparisDetayi() {

		List<Musteri> musteriSiparisleri = musteriDao.listAll();

		for (Musteri musteri : musteriSiparisleri) {
			System.out.println("Müşterinin ID=" + musteri.getId() + " Müşterinin adi: " + musteri.getAd() + " Müşterinin Soyadi= "
					+ musteri.getSoyad());
			for (Siparis siparis : musteri.getSiparis()) {
				System.out.println("Sipariş ID=" + siparis.getId());
				for (SiparisKalemii siparisKalemi : siparis.getSiparisKalemleri()) {
					System.out.println("Ürün= " + siparisKalemi.getUrun().getAd() + " Ürün Fiyatı= "
							+ siparisKalemi.getUrun().getFiyat() + " Adet= " + siparisKalemi.getAdet());
				}

			}
		}

	}
	
	public void musteriCek() {
		musteriDao.siparisIDyegoremustericek();
	}

}
