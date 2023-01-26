package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.StringBuilder;

/**
 * Transforms given input to Latex suitable format
 */

public class LatexTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(LatexTransformer.class);
    /**
     * Creates TextTransformer input for further Latex transformation
     */
    public LatexTransformer(TextTransformer component) {
        super(component);
    }
    
    /**
     * Transforms input to Latex format
     *
     * @param text string input given to transform to Latex
     * @return Latex suitable string
     */
    @Override
    public String transform(String text) {
        String input = super.transform(text);
        StringBuilder output = new StringBuilder();

         for (char c : input.toCharArray()) {
            switch (c) {
               case '&':
                  output.append("\\&");
                  break;
               case '%':
                  output.append("\\%");
                  break;
               case '*':
                  output.append("\\*");
                  break;
               case '#':
                  output.append("\\#");
                  break;
               case '$':
                  output.append("\\$");
                  break;
               default:
                  output.append(c);
                  break;
            }
        }

         return output.toString();
    }
}
