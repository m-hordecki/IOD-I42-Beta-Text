package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.data.RequestData;
import pl.put.poznan.transformer.data.ResponseData;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseData post(@RequestBody RequestData request) {

        // log the parameters
        logger.debug(request.getText());
        logger.debug(Arrays.toString(request.getTransforms()));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(request.getTransforms());
        return new ResponseData(transformer.transform(request.getText()));
    }
}


