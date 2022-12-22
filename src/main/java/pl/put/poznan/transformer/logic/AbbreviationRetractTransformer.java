package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.data.Abbreviations;

public class AbbreviationRetractTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(AbbreviationRetractTransformer.class);

    public AbbreviationRetractTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        for(String expansion : Abbreviations.getInstance().getExpansions())
        {
            transformed = transformed.replace(expansion, Abbreviations.getInstance().getAbbreviation(expansion));
        }
        logger.debug("Result: {}", transformed);
        return transformed;
    }
}
