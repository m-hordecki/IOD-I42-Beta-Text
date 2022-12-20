package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToUppercaseTransformer extends TextTransformerDecorator {
    private static final Logger logger = LoggerFactory.getLogger(ToUppercaseTransformer.class);

    public ToUppercaseTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        String result = transformed.toUpperCase();
        logger.debug("Result: {}", result);
        return result;
    }
}
