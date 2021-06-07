package level3.lesson6.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcTest {
    private Calculator calculator;

    @Test
    public void testAdd() {
        calculator = new Calculator();
        Assertions.assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void testSub() {
        calculator = new Calculator();
        Assertions.assertEquals(5, calculator.sub(10, 5));
    }

    @Test
    public void testMul() {
        calculator = new Calculator();
        Assertions.assertEquals(25, calculator.mul(5, 5));
    }

    @Test
    public void testDiv() {
        calculator = new Calculator();
        Assertions.assertEquals(2, calculator.div(4, 2));
    }

    @Test
    public void testArraySum() {
        calculator = new Calculator();
        int[] array = {1, 2, 3};
        Assertions.assertEquals(6, calculator.arraySum(array));
    }
}
