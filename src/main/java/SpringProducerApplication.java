import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringProducerApplication implements CommandLineRunner {

    private static String TOPIC_NAME = "test";

    /** KafkaTemplate을 @Autowired 어노테이션으로 주입받아 사용
     * 사용자가 직접 선언하지 않은 bean 객체지만
     * 스프링 카프카에서 제공하는 객체로 주입된다.
     * application.yaml에 선언한 옵션값은 자동으로 주입된다.*/
    @Autowired
    private KafkaTemplate<Integer, String> template;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringProducerApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0 ; i < 10 ; i++) {
            template.send(TOPIC_NAME, "test" + i);
        }
        System.exit(0); // 작업 완료 후 종료
    }
}
