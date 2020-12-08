package com.diana.tema6.observer;

import java.time.LocalDate;

public interface BusyObjectObserver {

	public void update(String name, LocalDate creationDate);

}
