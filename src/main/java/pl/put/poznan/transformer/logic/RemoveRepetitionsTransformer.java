package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveRepetitionsTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(RemoveRepetitionsTransformer.class);

    public RemoveRepetitionsTransformer(TextTransformer component) {
        super(component);
    }

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
