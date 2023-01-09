package com.melihcanozturk.observer;

public class Kaptan implements SonarObserver,OksijenObserver,YanginObserver {

	@Override
	public void update(SonarMesaj m) {
		System.out.println("Kaptana sonar uyarısı : " + m.getMessageContent());
		
	}
	@Override
	public void update(OksijenSensorMesaj m) {
		System.out.println("Kaptana Oksijen Uyarısı  : "+ m.getMessageContent());
		
	}
	
	@Override
	public void update(YanginMesaj m) {
		System.out.println("Kaptana Yangın Uyarısı : "+ m.getMessageContent());
		
	}
}
