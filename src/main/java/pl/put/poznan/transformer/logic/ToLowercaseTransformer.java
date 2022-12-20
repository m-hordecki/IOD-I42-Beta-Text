package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.rest.TextTransformerController;

public class ToLowercaseTransformer extends TextTransformerDecorator {
    private static final Logger logger = LoggerFactory.getLogger(ToLowercaseTransformer.class);

    public ToLowercaseTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        String result = transformed.toLowerCase();
        logger.debug("Result: {}", result);
        return result;
    }
}
