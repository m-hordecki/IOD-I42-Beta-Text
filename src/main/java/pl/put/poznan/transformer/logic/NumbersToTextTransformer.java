package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;
import pl.put.poznan.transformer.data.NumbersToTextData;

public class NumbersToTextTransformer extends TextTransformerDecorator
{
    private static final Logger logger = LoggerFactory.getLogger(NumbersToTextTransformer.class);

    public NumbersToTextTransformer(TextTransformer component)
    {
        super(component);
    }

    private final String intRegex = "^[0-9]{1,4}$";
    private final String floatRegex = "^[0-9]{1,4}\\.[0-9]{1,2}$";

    @Override
    public String transform(String text)
    {
        String transformed = super.transform(text);
        String[] splitText = transformed.split(" ");

        Pattern intPattern = Pattern.compile(intRegex);
        Pattern floatPattern = Pattern.compile(floatRegex);

        StringBuilder builder = new StringBuilder();
        for (String s : splitText)
        {
            if(floatPattern.matcher(s).find())
            {
                builder.append(convertFloat(s)).append(" ");
            }
            else if(intPattern.matcher(s).find())
            {
                builder.append(convertInt(s)).append(" ");
            }
            else
            {
                builder.append(s).append(" ");
            }
        }
        //remove trailing space
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private String convertInt(String value)
    {
        StringBuilder builder = new StringBuilder();
        boolean teen = false;
        for(int i = 0; i < value.length(); i++)
        {
            char character = value.charAt(i);
            int index = value.length() - 1 - i;
            //special cases
            if(index == 1 && character == '1')
            {
                //teens
                teen = true;
                continue;
            }
            if(index == 0 && teen)
            {
                builder.append(NumbersToTextData.teens.get(character));
                continue;
            }
            if(character == '0' && (index != 0 || value.length() > 1))
            {
                //omit zero
                continue;
            }
            builder.append(NumbersToTextData.numbers.get(index).get(character));
            if(index > 0)
            {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private String convertFloat(String value)
    {
        String[] split = value.split("\\.");
        return convertInt(split[0]) + " i " + convertDecimals(split[1]);
    }

    private String convertDecimals(String value)
    {
        StringBuilder builder = new StringBuilder();
        boolean teen = false;
        boolean leadingZero = false;
        for(int i = 0; i < value.length(); i++)
        {
            char character = value.charAt(i);
            int index = value.length() - 1 - i;
            //special cases
            if(i == 0 && character == '0')
            {
                leadingZero = true;
                continue;
            }
            if(index == 1 && character == '1')
            {
                //teens
                teen = true;
                continue;
            }
            if(index == 0 && teen)
            {
                builder.append(NumbersToTextData.teens.get(character));
                continue;
            }
            if(character == '0')
            {
                //omit zero
                continue;
            }
            builder.append(NumbersToTextData.decimals.get(index).get(character));
            if(index > 0)
            {
                builder.append(" ");
            }
        }
        builder.append(" ");
        if(value.length() == 1)
        {
            builder.append(NumbersToTextData.tenths.get(value.charAt(0)));
        }
        else
        {
            if(leadingZero)
            {
                builder.append(NumbersToTextData.hundredths.get(value.charAt(1)));
            }
            else
            {
                builder.append(NumbersToTextData.hundredths.get('9'));
            }
        }
        return builder.toString();
    }
}
