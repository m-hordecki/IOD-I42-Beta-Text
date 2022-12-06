package pl.put.poznan.transformer.logic;

public class EmptyTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        return text;
    }
}
