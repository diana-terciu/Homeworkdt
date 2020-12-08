package com.diana.tema6.observer;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusyObject {
	private Integer id;
	private String name;
	private LocalDate creationDate;
	private ArrayList<BusyObjectObserver> observers = new ArrayList<BusyObjectObserver>();

	public void addObserver(BusyObjectObserver busyObjectObserver) {
		observers.add(busyObjectObserver);
	}

	public void updateObjectAndDependencies(String name, LocalDate creationDate) {
		this.name = name;
		if (creationDate.isBefore(this.creationDate)) {
			throw new IllegalArgumentException("The date can't be set before the original creation date");
		}
		notifyObservers(name, creationDate);

	}

	public void notifyObservers(String name, LocalDate creationDate) {
		observers.forEach(busyObjectObserver -> busyObjectObserver.update(name, creationDate));

	}

}
