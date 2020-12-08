package com.diana.tema6.strategy;

public class MyTestS {
	public static void main(String[] args) {
		User myUser = new User("Diana", "Terciu");
		useStrategy(myUser, FindStrategy.LAST_NAME);
		useStrategy(myUser, FindStrategy.NO_NAME);

	}

	public static void useStrategy(User user, FindStrategy strategy) {
		strategy.getStrategy().accept(user);
	}

	/*
	 * public void useStrategy(String firstName, String lastName, String strategy) {
	 * if (strategy.equals("firstNameFirst")) { System.out.println(firstName + " " +
	 * lastName); } else if (strategy.equals("lastNameFirst")) {
	 * System.out.println(lastName + " " + firstName); } else {
	 * System.out.println("Not a valid strategy"); } }
	 */
}
