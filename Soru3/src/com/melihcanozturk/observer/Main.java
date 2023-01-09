package com.melihcanozturk.observer;

public class Main {

	
	public static void main(String[] args) {
		
		
		Kaptan s1 = new Kaptan();
		Haberlesmeci s2 = new Haberlesmeci();
		TorpidoMerkez s3 = new TorpidoMerkez();
		
		
		
		OksijenPublisher p = new OksijenPublisher();
		p.attach(s1);
		
		p.notifyUpdate(new OksijenSensorMesaj("Düşük oksijen seviyesi!", 10, "Silah Binası"));
		
		System.out.println("\n ********* \n");
		
		YanginPublisher p2 = new YanginPublisher();
		p2.attach(s1);
		p2.attach(s2);
		
		p2.notifyUpdate(new YanginMesaj("Yangın alarmı aktif", 90, 35));
		
		System.out.println("\n ********* \n");
		
		
		SonarPublisher p3 = new SonarPublisher();
		p3.attach(s1);
		p3.attach(s2);
		p3.attach(s3);
		
		p3.notifyUpdate(new SonarMesaj("Bilinmeyen denizaltı yaklaşıyor", "214 TN", 50, 32, 44));
	
	}

}
