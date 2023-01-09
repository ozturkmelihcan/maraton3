package com.melihcanozturk.observer;

public class OksijenSensorMesaj {

	final String messageContent;
	final int oksijenYuzdesi;
	final String oksijenLokasyonu;
	
	
	public OksijenSensorMesaj(String messageContent, int oksijenYuzdesi, String oksijenLokasyonu) {
		super();
		this.messageContent = messageContent;
		this.oksijenYuzdesi = oksijenYuzdesi;
		this.oksijenLokasyonu = oksijenLokasyonu;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public int getOksijenYuzdesi() {
		return oksijenYuzdesi;
	}


	public String getOksijenLokasyonu() {
		return oksijenLokasyonu;
	}


	@Override
	public String toString() {
		return "MessageOksijenSensor [messageContent=" + messageContent + ", oksijenYuzdesi="
				+ oksijenYuzdesi + ", oksijenLokasyonu=" + oksijenLokasyonu + "]";
	}
	

	
}
