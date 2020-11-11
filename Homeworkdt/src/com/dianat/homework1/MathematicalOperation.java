package com.dianat.homework1;

sealed interface MathematicalOperation permits Addition, Substraction {

	Integer getResult(Integer a, Integer b);
}
