package level3.lesson6.junit;

import org.junit.jupiter.api.*;

public class Calc2Test {
    private static Calculator calculator;

    // @AfterEach
    // @BeforeAll
    // @AfterAll
    // @BeforeEach
    @BeforeAll
    public static void init() { calculator = new Calculator(); }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(8, calculator.sub(10, 2));
    }

    @Test
    @Disabled("Деление пока не тестируем! Тест отключен мануально.")
    public void destDiv() {
        Assertions.assertEquals(1, calculator.div(2, 2));
    }

    @Test
    public void testExceptions() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            throw new ArithmeticException();
        });
    }
}
