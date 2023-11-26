package com.application;

import com.pipeline.ProduceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/")
    public String index() {
        logger.info("index controller");
        return "favorite-color-webpage";
    }
}
