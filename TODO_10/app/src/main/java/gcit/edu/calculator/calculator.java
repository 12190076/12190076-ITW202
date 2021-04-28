package gcit.edu.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class calculator {
    public enum operator{ADD, SUB, MUL, DIV}
    public double add(double operator1,double operator2){
        return operator1 + operator2;
    }

    public double sub(double operator1,double operator2){
        return operator1 - operator2;
    }

    public double mul(double operator1,double operator2){
        return operator1 * operator2;
    }

    public double div(double operator1,double operator2){
        return operator1 / operator2;
    }
}
//
