package cute.coder.eurekaclient1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "cute.coder.eurekaclient1.mapper")
public class EurekaClient1Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClient1Application.class).web(true).run(args);

    }

}
