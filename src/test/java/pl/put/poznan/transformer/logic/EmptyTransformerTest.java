package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyTransformerTest {
    static String[] testStrings = new String[]{"test"};
    static String[] expectedResultStrings = new String[]{"test"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            EmptyTransformer EmptyTransformer = new EmptyTransformer();
            String result = EmptyTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}