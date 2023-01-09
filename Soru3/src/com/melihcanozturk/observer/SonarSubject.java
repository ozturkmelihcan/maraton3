package com.melihcanozturk.observer;

public interface SonarSubject {
	public void attach(SonarObserver o);
	public void detach(SonarObserver o);
	public void notifyUpdate(SonarMesaj m);
}
