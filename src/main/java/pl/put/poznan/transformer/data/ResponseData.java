package pl.put.poznan.transformer.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {
    private final String text;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ResponseData(@JsonProperty("content") String content)
    {
        this.text = content;
    }

    public String getText()
    {
        return text;
    }
}
