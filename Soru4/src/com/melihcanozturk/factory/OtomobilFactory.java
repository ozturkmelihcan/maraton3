package com.melihcanozturk.factory;

public class OtomobilFactory {

	public IOtomobil createOtomobil(String otoType) {

		if (otoType == null || otoType.isEmpty())
			return null;

		switch (otoType) {
		case IOtomobil.AUDI:
			return new OtoAudi();
		case IOtomobil.RENAULT:
			return new OtoRenault();
		case IOtomobil.TOYOTA:
			return new OtoToyota();
		default:
			throw new IllegalArgumentException("Unknown oto type:" + otoType);

		}

	}
}
