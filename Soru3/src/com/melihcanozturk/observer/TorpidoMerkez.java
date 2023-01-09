package com.melihcanozturk.observer;

public class TorpidoMerkez implements SonarObserver {

	@Override
	public void update(SonarMesaj m) {
		System.out.println("Torpido Merkezine giden sonar uyarısı : "+m.getMessageContent());
		
		
	}


}
