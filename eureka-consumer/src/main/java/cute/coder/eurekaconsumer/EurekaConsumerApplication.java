package cute.coder.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaConsumerApplication.class).web(true).run(args);

    }

}
