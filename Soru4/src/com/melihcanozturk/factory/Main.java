package com.melihcanozturk.factory;

public class Main {

	public static void main(String[] args) {


		OtomobilFactory factory = Singleton.getUretim();
		factory.createOtomobil(IOtomobil.AUDI).uretiliyor();
		factory.createOtomobil(IOtomobil.RENAULT).uretiliyor();
		factory.createOtomobil(IOtomobil.TOYOTA).uretiliyor();
	}

}
