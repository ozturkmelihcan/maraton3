package com.melihcanozturk.observer;

import java.util.ArrayList;
import java.util.List;

public class YanginPublisher implements YanginSubject {
	
	private List<YanginObserver> observers = new ArrayList<>();

	@Override
	public void attach(YanginObserver o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void detach(YanginObserver o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
		
	}

	@Override
	public void notifyUpdate(YanginMesaj m) {
		for (YanginObserver o : observers) {
			o.update(m);
		}
	}




}
