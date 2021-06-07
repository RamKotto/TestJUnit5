package level3.lesson6.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CalcMassTest {
    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "7, 5, 12",
            "12, 12, 24"
    })
    @ParameterizedTest
    public void massTestAdd(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }


    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void testAddOperation(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = (int)(Math.random() * 1000);
            int b = (int)(Math.random() * 1000);
            int result = a + b;
            out.add(Arguments.arguments(a, b, result));
        }
        return out.stream();
    }


    @ParameterizedTest
    @MethodSource("dataForArraySumOperation")
    public void testArraySumOperation(int[] array, int result) {
        Assertions.assertEquals(result, calculator.arraySum(array));
    }

    public static Stream<Arguments> dataForArraySumOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 1, 1}, 3));
        out.add(Arguments.arguments(new int[] {2, 1, 1}, 4));
        out.add(Arguments.arguments(new int[] {1, 3, 1}, 5));
        out.add(Arguments.arguments(new int[] {10, 12, 13}, 35));
        out.add(Arguments.arguments(new int[] {11, 1, 5}, 17));
        return out.stream();
    }
}
