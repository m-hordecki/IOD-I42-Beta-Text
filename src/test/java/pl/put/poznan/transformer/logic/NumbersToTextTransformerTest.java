package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumbersToTextTransformerTest {
    static String[] testStrings = new String[]{"Twoja szczęśliwa liczba to 351"};
    static String[] expectedResultStrings = new String[]{"Twoja szczęśliwa liczba to trzysta pięćdziesiąt jeden"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            NumbersToTextTransformer numbersToTextTransformer = new NumbersToTextTransformer(mockTextTransformer);
            String result = numbersToTextTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}