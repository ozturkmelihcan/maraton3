package com.melihcanozturk.observer;

import java.util.ArrayList;
import java.util.List;

public class OksijenPublisher implements OksijenSubject {
	
	private List<OksijenObserver> observers = new ArrayList<>();

	@Override
	public void attach(OksijenObserver o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void detach(OksijenObserver o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
		
	}

	@Override
	public void notifyUpdate(OksijenSensorMesaj m) {
		for (OksijenObserver o : observers) {
			o.update(m);
		}
	}



}
