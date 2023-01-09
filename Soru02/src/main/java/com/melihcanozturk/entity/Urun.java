package com.melihcanozturk.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Urun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String ad;
	private int fiyat;

	public Urun(String ad, int fiyat) {
		super();
		this.ad = ad;
		this.fiyat = fiyat;
	}

	public Urun() {
		super();

	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
