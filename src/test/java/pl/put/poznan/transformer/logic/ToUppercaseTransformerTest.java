package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToUppercaseTransformerTest {
    static String[] testStrings = new String[]{"321tEsT123"};
    static String[] expectedResultStrings = new String[]{"321TEST123"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            ToUppercaseTransformer toUppercaseTransformer = new ToUppercaseTransformer(mockTextTransformer);
            String result = toUppercaseTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}