package com.pipeline;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.vo.UpbitCoinInfoDto;
import com.vo.UserEventVO;
import org.apache.commons.net.ntp.TimeStamp;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") /* 다른 도메인 호출 허용 */
public class ProduceController {

    private final Logger logger = LoggerFactory.getLogger(ProduceController.class);

    private static String APPLICATION_NAME = "processor-application";
    private static String TOPIC_NAME = "upbit-coin-info";
    private static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    //    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public ProduceController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
    @Autowired
    private KafkaTemplate<String, String> customKafkaTemplate;

    //    @GetMapping("/api/select")
//    public void selectColor(@RequestHeader("user-agent") String userAgentName
//                            , @RequestParam(value = "color") String colorName
//                            , @RequestParam(value = "user") String userName) {
//
//        logger.info("selectColor Api");
//
//        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
//        Date now = new Date();
//        Gson gson = new Gson();
//
//        UserEventVO userEventVO = new UserEventVO(sdfDate.format(now), userAgentName, colorName, userName);
//        String jsonColorLog = gson.toJson(userEventVO);
//
//        customKafkaTemplate.send("select-color", jsonColorLog).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                logger.error(ex.getMessage(), ex);
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                logger.info(result.toString());
//            }
//        });
//    }

    @GetMapping("/api/list")
    public void coinList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://api.upbit.com/v1/ticker?markets=KRW-BTC");

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            String responseInfo = EntityUtils.toString(entity, "UTF-8");
            logger.info(responseInfo);

            try {
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); //파라미터Map에서 DTO에 들어있지 않는변수가있어도무시함.
                List<UpbitCoinInfoDto> list = mapper.convertValue(responseInfo, TypeFactory.defaultInstance().constructCollectionType(List.class, UpbitCoinInfoDto.class));
            } catch (Exception e) {};
   
            TimeStamp timeStamp = new TimeStamp(System.currentTimeMillis());
            String key = timeStamp.toString();
            customKafkaTemplate.send("upbit-coin-info", key, responseInfo).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable ex) {
                    logger.error(ex.getMessage(), ex);
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    logger.info(result.toString());
                }
            });
        } catch(Exception e) {
            logger.error(e.getMessage());
            return;
        }
    }
}
