package com.melihcanozturk.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Siparis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Musteri musteri;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SiparisKalemii> siparisKalemleri;


	public Siparis() {

	}

	public Siparis(Musteri musteri, List<SiparisKalemii> siparisKalemleri) {
		super();
		this.musteri = musteri;
		this.siparisKalemleri = siparisKalemleri;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	public List<SiparisKalemii> getSiparisKalemleri() {
		return siparisKalemleri;
	}

	public void setSiparisKalemleri(List<SiparisKalemii> siparisKalemleri) {
		this.siparisKalemleri = siparisKalemleri;
	}

}
