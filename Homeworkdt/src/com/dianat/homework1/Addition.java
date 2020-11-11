package com.dianat.homework1;

public record Addition(Integer operandA, Integer operandB) implements MathematicalOperation {

	@Override
	public Integer getResult(Integer a, Integer b) {
		return a + b;
	}

}
