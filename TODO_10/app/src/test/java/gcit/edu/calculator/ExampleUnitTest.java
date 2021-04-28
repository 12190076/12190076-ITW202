package gcit.edu.calculator;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new calculator();
    }
//Addition
    @Test
    public void addTwoNumber() {
        double result = mCalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNumberforNegative() {
        double result = mCalculator.add(-1d, 2d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void addTwoNumberFloat() {
        double result = mCalculator.add(1.111d, 1.1111d);
        assertThat(result, is(closeTo(2.222d,0.01)));
    }
    //Substraction
    @Test
    public void subTwoNumber() {
        double result = mCalculator.sub(5d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void subTwoNumberforNegative() {
        double result = mCalculator.sub(-5d, 2d);
        assertThat(result, is(equalTo(-7d)));
    }
    @Test
    public void subTwoNumberFloat() {
        double result = mCalculator.sub(2.222f, 1.1111d);
        assertThat(result, is(closeTo(1.111d,1.111)));
    }
    //Multiplication
    @Test
    public void mulTwoNumber() {
        double result = mCalculator.mul(5d, 2d);
        assertThat(result, is(equalTo(10d)));
    }
    @Test
    public void mulTwoNumberforNegative() {
        double result = mCalculator.mul(-5d, 2d);
        assertThat(result, is(equalTo(-10d)));

    }
    @Test
    public void mulTwoNumberFloat() {
        double result = mCalculator.mul(5.55f, 2.22f);
        assertThat(result, is(closeTo(12.222d,12.21)));
    }
    //Division
    @Test
    public void divTwoNumber() {
        double result = mCalculator.div(4d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumberforNegative() {
        double result = mCalculator.div(-5d, 2d);
        assertThat(result, is(equalTo(-2.5d)));
    }
    @Test
    public void divTwoNumberFloat() {
        double result = mCalculator.div(9.33f, 3.22d);
        assertThat(result, is(closeTo(3.222d,2.01)));
    }
}