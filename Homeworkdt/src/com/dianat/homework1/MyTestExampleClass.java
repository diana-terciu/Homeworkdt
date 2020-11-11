package com.dianat.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class MyTestExampleClass {

	/*
	 * 3.Write a method that calls randomOptionalGenerator. If it returns a value,
	 * print it. Otherwise, print the message: “You’ve reached the end of INT”
	 */
	public static void main(String[] args) {
		// 1.
		// TODO Auto-generated method stub
		Map<Integer, String> testMap = mapExample();
		/*
		 * this fails with java.lang.UnsupportedOperationException because is immutable
		 * so keys and values cannot be added, removed, or updated no null keys / values
		 * are allowed
		 */
		testMap.put(2, "contract");
		System.out.println(testMap);

		// 2.
		// System.out.println(
		// randomOptionalGenerator().orElseThrow(NullPointerException::new));

		// 3.
		Optional<Integer> myOptional = randomOptionalGenerator();
		myOptional.ifPresentOrElse(v -> System.out.println(v),
				() -> System.out.println("You’ve reached the end of INT"));

		// 4.
		System.out.println(differenceBetweenLargestAndSmallest());

		// 5. ArrayList
		List<String> myList = new ArrayList<>();
		myList.add("Product");
		myList.add("Service");
		myList.add("Agreement");
		testInstaceOfExample(myList);

		// 5. LinkedList
		List<String> myLinkedList = new LinkedList<>();
		myLinkedList.add("Agreement");
		myLinkedList.add("Product");
		myLinkedList.add("Service");

		testInstaceOfExample(myLinkedList);

		// 6.
		Map placeHolderMap = new HashMap();
		placeHolderMap.put("name", "World");
		placeHolderMap.put("greeting", "Heyyy");
		System.out.println("Text blocks example is: " + generateViewTemplate(placeHolderMap));

		// 7.
		System.out.println("  " + checkWeekDays(WeekDaysEnum.SUNDAY));

		// 8.
		System.out.println(" Math operations are " + checkMathOperations(new Addition(2, 3), new Addition(2, 3)));
	}

	/*
	 * 1.Write a method that returns a Map<Integer, String> called mapExample. Fill
	 * it with 3 separate key - value pairs. Call it from another method and add
	 * something to the results. Add a comment in your code to explain the whole
	 * behavior (why it works / fails)
	 */
	public static Map<Integer, String> mapExample() {
		// Map<Integer,String> myMapExample = Map.ofEntries(entry(1, "product"),
		// entry(2, "service"), entry(3, "agreement"));

		HashMap<Integer, String> myMapExample = new HashMap<Integer, String>();

		myMapExample.put(1, "product");
		myMapExample.put(2, "service");
		myMapExample.put(3, "agreement");

		return myMapExample;
	}

	/*
	 * 2.Write a method that returns an Optional<Integer>, called
	 * randomOptionalGenerator. Randomly, the result should be either value 1 or an
	 * empty value. Call it from another method and, if it contains no result, throw
	 * an exception
	 */
	public static Optional<Integer> randomOptionalGenerator() {
		List<Integer> list = Arrays.asList(1, null);
		Random rand = new Random();
		Supplier<Integer> randomValue = () -> list.get(rand.nextInt(list.size()));

		return Optional.ofNullable(randomValue.get());
	}

	/*
	 * 4. Write a method that calculates the difference between the largest and the
	 * smallest number in a list of integers.
	 */

	public static Integer differenceBetweenLargestAndSmallest() {
		List<Integer> list = List.of(1, 33, 55, 78);
		var maxValue = list.stream().max(Integer::compare).get();
		var minValue = list.stream().min(Integer::compare).get();
		return Math.subtractExact(maxValue, minValue);
	}

	/*
	 * 5. Write a method that takes a List<String> as a parameter. If it’s an
	 * ArrayList, iterate over it using forEach, and print each element. If it’s a
	 * LinkedList and it’s not empty, iterate over it using descendingIterator.
	 * Otherwise, print a disappointing error message.
	 */

	public static void testInstaceOfExample(List<String> myStringList) {

		if (myStringList instanceof ArrayList<?> myArrayList) {
			myStringList.forEach((e) -> {
				System.out.println("Array list value: " + e);
			});

		} else if (myStringList instanceof LinkedList myLinkedList) {
			if (!myLinkedList.isEmpty()) {
				Iterator x = myLinkedList.descendingIterator();

				while (x.hasNext()) {
					System.out.println("Linked list value is : " + x.next());
				}

			}
		}
	}

	/*
	 * 6. Write a method called generateViewTemplate. The view takes a Map<String,
	 * String> as input. The method first defines a simple HTML template. It should
	 * return a page containing the text: Hello ${name}. ${greeting}. Replace
	 * ${name} and ${greeting} with the values corresponding to the keys with the
	 * same names from the input map. Return the result. Print it in the calling
	 * function. Hint: use text blocks and text block specific methods
	 */

	public static String generateViewTemplate(Map<String, String> placeHolderMap) {
		String htmlContent = """
				 <html>
				      <body>
				          <p> Hello ${name}. ${greeting}.</p>
				      </body>
				  </html>
				""";
		htmlContent = htmlContent.replace("${name}", placeHolderMap.get("name"));
		htmlContent = htmlContent.replace("${greeting}", placeHolderMap.get("greeting"));
		return htmlContent;
	}

	/*
	 * 7. Define an enum with the days of the week. Add to it a function which
	 * returns a string describing whether it’s a workday or a weekend day.
	 */

	public static String checkWeekDays(WeekDaysEnum myEnum) {
		String dayType = "";
		switch (myEnum) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			dayType = "It's a work day";
			break;
		case SATURDAY:
		case SUNDAY:
			dayType = "It's a weekend day";
			break;
		default:

		}
		return dayType;
	}

	/*
	 * 8.Define an interface called MathematicalOperation. Extend it, and only allow
	 * Addition and Subtraction as operations. Each of these operations should be
	 * defined as records. Each of them should have the two operands and a way to
	 * calculate a result. Write a function that takes two such operations and
	 * returns true if they are identical.
	 */

	public static boolean checkMathOperations(MathematicalOperation o1, MathematicalOperation o2) {
		return o1.equals(o2);
	}
}