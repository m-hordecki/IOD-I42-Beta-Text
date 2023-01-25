package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LatexTransformerTest {
    static String[] testStrings = new String[]{"test&test","test%test","test*test","test#test","test$test"};
    static String[] expectedResultStrings = new String[]{"test\\&test","test\\%test","test\\*test","test\\#test","test\\$test"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            LatexTransformer LatexTransformer = new LatexTransformer(mockTextTransformer);
            String result = LatexTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}