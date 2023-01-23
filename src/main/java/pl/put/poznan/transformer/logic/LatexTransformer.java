package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.StringBuilder;

public class LatexTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(LatexTransformer.class);

    public LatexTransformer(TextTransformer component) {
        super(component);
    }

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
