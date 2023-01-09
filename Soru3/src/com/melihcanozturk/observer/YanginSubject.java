package com.melihcanozturk.observer;

public interface YanginSubject {

	void attach(YanginObserver o);

    void detach(YanginObserver o);

    void notifyUpdate(YanginMesaj m);
	
}
