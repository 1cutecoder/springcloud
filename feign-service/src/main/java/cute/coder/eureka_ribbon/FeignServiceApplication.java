package cute.coder.eureka_ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableFeignClients
public class FeignServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignServiceApplication.class).web(true).run(args);

    }

}
