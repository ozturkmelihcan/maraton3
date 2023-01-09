package com.melihcanozturk.observer;

import java.util.ArrayList;
import java.util.List;

public class SonarPublisher implements SonarSubject {

	
		
		private List<SonarObserver> observers = new ArrayList<>();
		
		@Override
		public void attach(SonarObserver o) {
			if(!observers.contains(o)) {
				observers.add(o);
			}
			
		}
	
		@Override
		public void detach(SonarObserver o) {
			if(observers.contains(o)) {
				observers.remove(o);
			}
			
		}
	
		@Override
		public void notifyUpdate(SonarMesaj m) {
		for (SonarObserver o : observers) {
			o.update(m);
		}
			
	}


}
