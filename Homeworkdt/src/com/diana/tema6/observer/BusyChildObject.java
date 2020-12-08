package com.diana.tema6.observer;

import java.time.LocalDate;

public class BusyChildObject implements BusyObjectObserver {
	private String name;
	private LocalDate creationDate;
	BusyObject busyObject;

	public BusyChildObject(BusyObject busyObject) {
		this.busyObject = busyObject;
		busyObject.addObserver(this);
	}

	@Override
	public void update(String name, LocalDate creationDate) {
		this.name = name;
		this.creationDate = creationDate;
		addHistoryMessage();
		updateChildren();
	}

	public void updateChildren() {
		System.out.println("updated" + name + creationDate);
	}

	public void addHistoryMessage() {
		System.out.println("updated" + name + creationDate);
	}

}
