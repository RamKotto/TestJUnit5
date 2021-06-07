package homework.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FireStarterTest {
    private static FireStarter fs;

    // Метод инициализации
    @BeforeAll
    public static void init() {
        fs = new FireStarter();
    }

    // Параметризированное массовое тестирование
    @ParameterizedTest
    @MethodSource("dataForFoursCutter")
    public void testFoursCutter(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, fs.foursCutter(array));
    }

    public static Stream<Arguments> dataForFoursCutter() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 2, 3, 4, 5, 6 ,7}, new int[] {5, 6, 7}));
        out.add(Arguments.arguments(new int[] {4, 2, 3, 4, 1, 4 ,1}, new int[] {1}));
        out.add(Arguments.arguments(new int[] {4, 8, 5 ,2}, new int[] {8, 5 ,2}));
        out.add(Arguments.arguments(new int[] {1, 2, 3, 4}, new int[] {}));
        return out.stream();
    }

    // Тест на исключение
    @Test
    public void testExceptions() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            fs.foursCutter(new int[] {1, 1, 1, 1});
        });
    }

    @ParameterizedTest
    @MethodSource("dataForFourAndOneSeeker")
    public void testFourAndOneSeeker(int[] array, boolean result) {
        Assertions.assertEquals(result, fs.fourAndOneSeeker(array));
    }

    public static Stream<Arguments> dataForFourAndOneSeeker() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {2, 2, 2}, false));
        out.add(Arguments.arguments(new int[] {1, 1, 2}, false));
        out.add(Arguments.arguments(new int[] {4, 8}, false));
        out.add(Arguments.arguments(new int[] {1, 2, 3, 4}, true));
        return out.stream();
    }

}
