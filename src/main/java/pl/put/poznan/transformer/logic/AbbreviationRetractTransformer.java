package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.data.Abbreviations;
/**
 * Retracts abbrevations in given input
 */
public class AbbreviationRetractTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(AbbreviationRetractTransformer.class);
    /**
     * Creates TextTransformer input for further abbrevations retraction
     */
    public AbbreviationRetractTransformer(TextTransformer component) {
        super(component);
    }
    /**
     * Retracts abbrevations
     *
     * @param text string input given to retract abbrevations
     * @return string with retracted abbreaviations 
     */
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
