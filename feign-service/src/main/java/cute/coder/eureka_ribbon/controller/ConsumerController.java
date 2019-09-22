package cute.coder.eureka_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by cute coder
 * 2019/8/27 20:54
 */
@RestController
//@DefaultProperties(defaultFallback = "test2")
public class ConsumerController{
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ConsumerClient consumerClient;

    //远程调用
    public String test2() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String url = "http://" + host + ":" + serviceInstance.getPort() + "hello";
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("超时");
        return "服务器太繁忙了，555" +"<br>" +s;
    }
    //熔断
    @RequestMapping("/test4/{id}")
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })*/
    public String hello(@PathVariable("id") int id) {
        String s = consumerClient.hello();
        return "test4" +"<br>"+id+"<br>"+ s;
    }
}
