package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbbreviationExpandTransformerTest {
    static String[] testStrings = new String[]{"testy, np. test", "M.in. jest to test", "Test, testy, itp.", "pan prof. Testowy", "dr. Oetker"};
    static String[] expectedResultStrings = new String[]{"testy, na przykład test", "Między innymi jest to test", "Test, testy, i tym podobne", "pan profesor Testowy", "doktor Oetker"};


    @Test
    void testTransform() {
        for(int i = 0; i < testStrings.length; i++) {
            String testString = testStrings[i];
            String expectedResultString = expectedResultStrings[i];

            TextTransformer mockTextTransformer = mock(EmptyTransformer.class);
            when(mockTextTransformer.transform(anyString())).thenAnswer(f -> f.getArguments()[0]);

            AbbreviationExpandTransformer abbreviationExpandTransformer = new AbbreviationExpandTransformer(mockTextTransformer);
            String result = abbreviationExpandTransformer.transform(testString);

            assertEquals(expectedResultString, result);
        }

    }
}