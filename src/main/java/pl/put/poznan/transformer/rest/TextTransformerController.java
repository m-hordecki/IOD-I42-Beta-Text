package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.data.RequestData;
import pl.put.poznan.transformer.data.ResponseData;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;

@RestController
@RequestMapping("/transform")
public class TextTransformerController {
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    private TextTransformer addTransformation(String transform, TextTransformer currentTransformer) {
        switch (transform) {
            case "upper":
                return new ToUppercaseTransformer(currentTransformer);
            case "lower":
                return new ToLowercaseTransformer(currentTransformer);
            case "capitalize":
                return new CapitalizeTransformer(currentTransformer);
            default:
                logger.warn("Incorrect transformation: {}", transform);
                return currentTransformer;
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseData post(@RequestBody RequestData request) {

        logger.info("Input: {}", request.getText());
        logger.info("Transforms: {}", Arrays.toString(request.getTransforms()));

        TextTransformer transformer = new EmptyTransformer();
        for (String transform : request.getTransforms()) {
            transformer = addTransformation(transform, transformer);
        }
        String result = transformer.transform(request.getText());
        logger.info("Result: {}", result);
        return new ResponseData(result);
    }
}


