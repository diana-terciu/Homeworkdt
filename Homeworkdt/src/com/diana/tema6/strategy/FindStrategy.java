package com.diana.tema6.strategy;

import java.util.function.Consumer;

public enum FindStrategy {
	FIRST_NAME((user) -> System.out.println(user.firstName() + " " + user.lastName())),
	LAST_NAME((user) -> System.out.println(user.lastName() + " " + user.firstName())),
	NO_NAME((user) -> System.out.println("Not a valid strategy"));

	Consumer<User> strategy;

	FindStrategy(Consumer<User> strategy) {
		this.strategy = strategy;
	}

	public Consumer<User> getStrategy() {
		return strategy;
	}

}
