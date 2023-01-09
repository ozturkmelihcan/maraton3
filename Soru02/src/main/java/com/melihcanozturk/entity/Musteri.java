package com.melihcanozturk.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Musteri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String ad;
	private String soyad;

	@OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Siparis> siparis;

	public Musteri() {
	}

	public Musteri(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public List<Siparis> getSiparis() {
		return siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}

}
