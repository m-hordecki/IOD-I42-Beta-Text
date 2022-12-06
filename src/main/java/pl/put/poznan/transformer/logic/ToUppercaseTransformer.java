package pl.put.poznan.transformer.logic;

public class ToUppercaseTransformer extends TextTransformerDecorator {

    public ToUppercaseTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        return transformed.toUpperCase();
    }
}
