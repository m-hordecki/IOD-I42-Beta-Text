package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CapitalizeTransformerTest {
    static String[] testStrings = new String[]{"tEsT123"};
    static String[] expectedResultStrings = new String[]{"Test123"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            CapitalizeTransformer capitalizeTransformer = new CapitalizeTransformer(mockTextTransformer);
            String result = capitalizeTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}