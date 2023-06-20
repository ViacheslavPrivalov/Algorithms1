package com.example.algorithms1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {
    private final StringList out = new StringListImpl();

    private static Stream<Arguments> paramsForTest() {
        return Stream.of(
                Arguments.of(0, "aaa"),
                Arguments.of(1, "bbb"),
                Arguments.of(2, "ccc"),
                Arguments.of(3, "abc")
        );
    }

    @BeforeEach
    public void init() {
        out.add(0, "aaaa");
        out.add(1, "bbbb");
        out.add(2, "cccc");
        out.add(3, "dddd");
        out.add(0, "abcd");
    }

    @ParameterizedTest
    @MethodSource("paramsForTest")
    public void shouldReturnString(int index, String item) {
        assertTrue(out.size() == 4);
        assertEquals(out.add(index, item), item);
        assertEquals(out.remove(index), item);

        assertEquals(out.add(item), item);
        assertEquals(out.remove(item), item);


        assertEquals(out.set(index, item), item);

        assertEquals(out.indexOf(item), index);
        assertEquals(out.lastIndexOf(item), index);

        out.add(index, item);
        assertEquals(out.contains(item), true);
        assertEquals(out.get(index), item);

    }
}
