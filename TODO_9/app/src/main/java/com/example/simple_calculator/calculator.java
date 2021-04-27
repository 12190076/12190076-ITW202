package com.example.simple_calculator;

public class calculator {
    public enum Operator {ADD, SUB, DIV, MUL}

    public double add(double operandone, double operandsecond) {
        return operandone + operandsecond;
    }
    public double sub(double operandone, double operandsecond) {
        return operandone - operandsecond;
    }
    public double div(double operandone, double operandsecond) {
        return operandone / operandsecond;
    }
    public double mul(double operandone, double operandsecond) {
        return operandone * operandsecond;
    }
}
