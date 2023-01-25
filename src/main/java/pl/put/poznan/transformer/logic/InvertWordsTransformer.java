package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvertWordsTransformer extends TextTransformerDecorator {
    private static final Logger logger = LoggerFactory.getLogger(ToLowercaseTransformer.class);

    public InvertWordsTransformer(TextTransformer component) {
        super(component);
    }

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
