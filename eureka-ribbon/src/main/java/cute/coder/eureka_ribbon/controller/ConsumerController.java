package cute.coder.eureka_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by cute coder
 * 2019/8/27 20:54
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test")
    public String test1() {
        String url = "http://eureka-client/hello";
        String s = restTemplate.getForObject(url, String.class);
        return "test" +"<br>"+ s;
    }


}
