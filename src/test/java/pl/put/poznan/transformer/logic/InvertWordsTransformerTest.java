package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvertWordsTransformerTest {
    static String[] testStrings = new String[]{"To jest testowe zdanie"};
    static String[] expectedResultStrings = new String[]{"oT tsej ewotset einadz"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            InvertWordsTransformer invertWordsTransformer = new InvertWordsTransformer(mockTextTransformer);
            String result = invertWordsTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}