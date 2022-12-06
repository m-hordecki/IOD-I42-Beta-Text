package pl.put.poznan.transformer.logic;

public class TextTransformerDecorator implements TextTransformer {
    private TextTransformer component;

    public TextTransformerDecorator(TextTransformer component) {
        this.component = component;
    }

    @Override
    public String transform(String text) {
        return component.transform(text);
    }
}
