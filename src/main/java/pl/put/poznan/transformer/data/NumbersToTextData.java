package pl.put.poznan.transformer.data;

import java.util.Map;

public class NumbersToTextData
{    
    public final static Map<Character, String> hundrets = Map.of(
        '1', "sto",
        '2', "dwieście",
        '3', "trzysta",
        '4', "czterysta",
        '5', "pięćset",
        '6', "sześcset",
        '7', "siedemset",
        '8', "osiemset",
        '9', "dziewięćset"
);

    public final static Map<Character, String> tens = Map.of(
            '2', "dwadzieścia",
            '3', "trzydzieści",
            '4', "czterdzieści",
            '5', "pięćdziesiąt",
            '6', "sześćdziesiąt",
            '7', "siedemdziesiąt",
            '8', "osiemdziesiąt",
            '9', "dziewiędziesiąt"
    );

    public final static Map<Character, String> digits = Map.of(
            '0', "zero",
            '1', "jeden",
            '2', "dwa",
            '3', "trzy",
            '4', "cztery",
            '5', "pięć",
            '6', "sześć",
            '7', "siedem",
            '8', "osiem",
            '9', "dziewięć"
    );

    public final static Map<Character, String> teens = Map.of(
            '0', "dziesięć",
            '1', "jedenaście",
            '2', "dwanaście",
            '3', "trzynaście",
            '4', "czternaście",
            '5', "piętnaście",
            '6', "szesnaście",
            '7', "siedemnaście",
            '8', "osiemnaście",
            '9', "dziewiętnaście"
    );

    public final static Map<Integer, Map<Character, String>> numbers = Map.of(
            2, hundrets,
            1, tens,
            0, digits
    );

    public final static Map<Character, String> tenths = Map.of(
            '1', "dziesiąta",
            '2', "dziesiąte",
            '3', "dziesiąte",
            '4', "dziesiąte",
            '5', "dziesiątych",
            '6', "dziesiątych",
            '7', "dziesiątych",
            '8', "dziesiątych",
            '9', "dziesiątych"
    );

    public final static Map<Character, String> hundredths = Map.of(
            '1', "setna",
            '2', "setne",
            '3', "setne",
            '4', "setne",
            '5', "setnych",
            '6', "setnych",
            '7', "setnych",
            '8', "setnych",
            '9', "setnych"
    );

    public final static Map<Character, String> decimalDigits = Map.of(
            '0', "zero",
            '1', "jedna",
            '2', "dwie",
            '3', "trzy",
            '4', "cztery",
            '5', "pięć",
            '6', "sześć",
            '7', "siedem",
            '8', "osiem",
            '9', "dziewięć"
    );

    public final static Map<Integer, Map<Character, String>> decimals = Map.of(
            1, tens,
            0, decimalDigits
    );
}
