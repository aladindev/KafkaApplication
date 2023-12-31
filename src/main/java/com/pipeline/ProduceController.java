package com.pipeline;

import com.google.gson.Gson;
import com.vo.UserEventVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") /* 다른 도메인 호출 허용 */
public class ProduceController {

    private final Logger logger = LoggerFactory.getLogger(ProduceController.class);

//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public ProduceController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
    @Autowired
    private KafkaTemplate<String, String> customKafkaTemplate;

    @GetMapping("/api/select")
    public void selectColor(@RequestHeader("user-agent") String userAgentName
                            , @RequestParam(value = "color") String colorName
                            , @RequestParam(value = "user") String userName) {

        logger.info("selectColor Api");

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
        Date now = new Date();
        Gson gson = new Gson();
 
        UserEventVO userEventVO = new UserEventVO(sdfDate.format(now), userAgentName, colorName, userName );
        String jsonColorLog = gson.toJson(userEventVO);

        customKafkaTemplate.send("select-color", jsonColorLog).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error(ex.getMessage(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info(result.toString());
            }
        });

    }
}
