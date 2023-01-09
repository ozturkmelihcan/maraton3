package com.melihcanozturk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SiparisKalemii {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Urun urun;
	
	private int adet;
	
//	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
//	private Siparis siparis;

	public SiparisKalemii() {
	
	}
	
	
	

	



	public SiparisKalemii(Urun urun, int adet) {
		super();
		this.urun = urun;
		this.adet = adet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Urun getUrun() {
		return urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	
	
	
	
	
	
}
