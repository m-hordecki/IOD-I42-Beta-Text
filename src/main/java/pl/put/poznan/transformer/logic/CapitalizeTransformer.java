package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.rest.TextTransformerController;

/**
 * Capitalizes each word in given input
 */
public class CapitalizeTransformer extends TextTransformerDecorator {

    private static final Logger logger = LoggerFactory.getLogger(CapitalizeTransformer.class);
    /**
     * Creates TextTransformer input for further capitalization
     */
    public CapitalizeTransformer(TextTransformer component) {
        super(component);
    }
    /**
     * Transforms first letter in a word to uppercase.
     *
     * @param text string input given to transform first letter to uppercase
     * @return capitalized string
     */
    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        transformed = transformed.toLowerCase();
        String[] split = transformed.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String s : split) {
            if(s.length() > 1) {
                builder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
            }
            else {
                builder.append(s.toUpperCase());
            }
            builder.append(" ");
        }
        String result = builder.toString();
        result = result.substring(0, result.length() - 1);
        logger.debug("Result: {}", result);
        return result;
    }
}

