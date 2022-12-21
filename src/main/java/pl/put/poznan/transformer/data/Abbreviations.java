package pl.put.poznan.transformer.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Abbreviations
{
    private class AbbreviationExpansion
    {
        private final String abbreviation;
        private final String expansion;

        private AbbreviationExpansion(String abbreviation, String expansion)
        {
            this.abbreviation = abbreviation;
            this.expansion = expansion;
        }

        public String getAbbreviation()
        {
            return abbreviation;
        }

        public String getExpansion()
        {
            return expansion;
        }
    }

    private final List<AbbreviationExpansion> list = List.of(
            new AbbreviationExpansion("np.", "na przykład"),
            new AbbreviationExpansion("m.in.", "między innymi"),
            new AbbreviationExpansion("itp.", "i tym podobne"),
            new AbbreviationExpansion("prof.", "profesor"),
            new AbbreviationExpansion("dr.", "doktor"),
            new AbbreviationExpansion("Np.", "Na przykład"),
            new AbbreviationExpansion("M.in.", "Między innymi"),
            new AbbreviationExpansion("Itp.", "I tym podobne"),
            new AbbreviationExpansion("Prof.", "Profesor"),
            new AbbreviationExpansion("Dr.", "Doktor")
        );

    private final Map<String, String> expansionToAbbreviation;
    private final Map<String, String> abbreviationToExpansion;

    private static Abbreviations instance;

    private Abbreviations()
    {
        expansionToAbbreviation = new HashMap<>();
        abbreviationToExpansion = new HashMap<>();
        for(AbbreviationExpansion ae : list)
        {
            expansionToAbbreviation.put(ae.getExpansion(), ae.getAbbreviation());
            abbreviationToExpansion.put(ae.getAbbreviation(), ae.getExpansion());
        }
    }

    public static Abbreviations getInstance()
    {
        if(instance == null)
        {
            instance = new Abbreviations();
        }
        return instance;
    }

    public Set<String> getExpansions()
    {
        return expansionToAbbreviation.keySet();
    }

    public String getExpansion(String abbreviation)
    {
        return abbreviationToExpansion.get(abbreviation);
    }

    public Set<String> getAbbreviations()
    {
        return abbreviationToExpansion.keySet();
    }

    public String getAbbreviation(String expansion)
    {
        return expansionToAbbreviation.get(expansion);
    }
}
