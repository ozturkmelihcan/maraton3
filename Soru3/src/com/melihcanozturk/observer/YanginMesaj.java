package com.melihcanozturk.observer;

public class YanginMesaj {

	final String messageContent;
	final int yanginLokasyonu;
	final int yanginSicakligi;
	
	
	public YanginMesaj(String messageContent, int yanginLokasyonu, int yanginSicakligi) {
		super();
		this.messageContent = messageContent;
		this.yanginLokasyonu = yanginLokasyonu;
		this.yanginSicakligi = yanginSicakligi;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public int getYanginLokasyonu() {
		return yanginLokasyonu;
	}


	public int getYanginSicakligi() {
		return yanginSicakligi;
	}


	@Override
	public String toString() {
		return "MessageYanginSensor [messageContent=" + messageContent + ", yanginLokasyonu=" + yanginLokasyonu
				+ ", yanginSicakligi=" + yanginSicakligi + "]";
	}
	

	
	
	
	
}
