package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Inverts words in given input
 */

public class InvertWordsTransformer extends TextTransformerDecorator {
    private static final Logger logger = LoggerFactory.getLogger(ToLowercaseTransformer.class);
    /**
     * Creates TextTransformer input for further capitalization
     */
    public InvertWordsTransformer(TextTransformer component) {
        super(component);
    }
    
    /**
     * Inverts every word
     *
     * @param text string input given to invert
     * @return inverted string
     */

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);

        String[] words = transformed.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(new StringBuilder(word).reverse());
            sb.append(" ");
        }

        String result = sb.toString().trim();

        logger.debug("Result: {}", result);
        return result;
    }
}
