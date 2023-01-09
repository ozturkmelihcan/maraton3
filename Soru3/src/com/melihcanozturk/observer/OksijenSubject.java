package com.melihcanozturk.observer;

public interface OksijenSubject {

	void attach(OksijenObserver o);

    void detach(OksijenObserver o);

    void notifyUpdate(OksijenSensorMesaj m);
	
}
