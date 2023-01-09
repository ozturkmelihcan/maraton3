package com.melihcanozturk.factory;



public class Singleton {

	private static OtomobilFactory uretim;
	
	
	public static OtomobilFactory getUretim() {
		if(uretim == null) {
			uretim = new OtomobilFactory();
		}
		return uretim;
	}
}
