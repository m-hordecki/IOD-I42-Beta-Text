package pl.put.poznan.transformer.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestData {
    private final String text;
    private final String[] transforms;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RequestData(@JsonProperty("text") String text,
                       @JsonProperty("transforms") String[] transforms) {
        this.text = text;
        this.transforms = transforms;
    }

    public String getText() {
        return text;
    }

    public String[] getTransforms() {
        return transforms;
    }
}
