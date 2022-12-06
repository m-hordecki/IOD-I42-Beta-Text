package pl.put.poznan.transformer.logic;

public class ToLowercaseTransformer extends TextTransformerDecorator {
    public ToLowercaseTransformer(TextTransformer component) {
        super(component);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        return transformed.toLowerCase();
    }
}
