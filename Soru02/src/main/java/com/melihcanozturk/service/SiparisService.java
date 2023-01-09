package com.melihcanozturk.service;

import java.util.List;

import com.melihcanozturk.repository.SiparisDao;
import com.melihcanozturk.entity.Siparis;
import com.melihcanozturk.entity.SiparisKalemii;

public class SiparisService {

	private SiparisDao siparisDao = new SiparisDao();

	public void siparisIdCek() {

		List<Siparis> musteriSiparisleri = siparisDao.listAll();

		for (int i = 0; i < musteriSiparisleri.size(); i++) {
			System.out.println("Musteri Ad= " + musteriSiparisleri.get(i).getMusteri().getAd() + ", Müşteri Soyad = "
					+ musteriSiparisleri.get(i).getMusteri().getSoyad() + ", Sipariş ID = "
					+ musteriSiparisleri.get(i).getId());

		}

	}

	public void siparislerinDetayiniGoster() {

		List<Siparis> musteriSiparisleri = siparisDao.listAll();

		for (Siparis siparis : musteriSiparisleri) {
			System.out.println("Sipariş ID= " + siparis.getId() + " Müşteri=" + siparis.getMusteri().getAd() + " "
					+ siparis.getMusteri().getSoyad() + " Müşteri ID= " + siparis.getMusteri().getId());
			int toplam = 0;
			for (SiparisKalemii siparisKalemi : siparis.getSiparisKalemleri()) {

				System.out.println("Ürün Adı:" + siparisKalemi.getUrun().getAd() + " Ürün Fiyatı= "
						+ siparisKalemi.getUrun().getFiyat() + " Adet Sayısı=" + siparisKalemi.getAdet());
				toplam = toplam + siparisKalemi.getUrun().getFiyat() * siparisKalemi.getAdet();

			}
			System.out.println(toplam);

		}

	}
	
	public void siparisAdedi() {
		siparisDao.SiparisAdedi();
	}

}
