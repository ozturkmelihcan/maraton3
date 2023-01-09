package com.melihcanozturk.observer;

public class Haberlesmeci implements SonarObserver,YanginObserver {


	@Override
	public void update(SonarMesaj m) {
		System.out.println("Haberleşmeciye Sonar Uyarısı : "+m.getMessageContent());
		
		
	}

	@Override
	public void update(YanginMesaj m) {
		System.out.println("Haberleşmeciye Yangın Uyarısı  "+m.getMessageContent());
		
	}


}
