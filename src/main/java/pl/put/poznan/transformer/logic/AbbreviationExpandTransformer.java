package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.data.Abbreviations;

public class AbbreviationExpandTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(AbbreviationExpandTransformer.class);

    public AbbreviationExpandTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        for(String abbreviation : Abbreviations.getInstance().getAbbreviations())
        {
            transformed = transformed.replace(abbreviation, Abbreviations.getInstance().getExpansion(abbreviation));
        }
        logger.debug("Result: {}", transformed);
        return transformed;
    }
}
