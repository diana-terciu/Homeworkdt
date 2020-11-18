package com.dianat.homework1;

sealed interface MathematicalOperation permits Addition, Substraction {

	default Integer getResult(Integer a, Integer b) {
		return a + b;
	}

}