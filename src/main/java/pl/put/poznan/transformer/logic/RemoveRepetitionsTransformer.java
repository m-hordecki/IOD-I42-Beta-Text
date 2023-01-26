package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Removes repetitions in given input
 */
public class RemoveRepetitionsTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(RemoveRepetitionsTransformer.class);
    /**
     * Creates TextTransformer input for further repetitions removal
     */
    public RemoveRepetitionsTransformer(TextTransformer component) {
        super(component);
    }
    /**
     * Removes repetitions
     *
     * @param text string input given to remove repetitions
     * @return string removed repetitions
     */
    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        String[] splitText = transformed.split(" ");
        List<String> resultList = new ArrayList<>();
        String last = "";
        for(String s : splitText)
        {
            if(!s.equals(last))
            {
                resultList.add(s);
                last = s;
            }
        }
        return String.join(" ", resultList);
    }
}
