package cute.coder.eureka_ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "test2")
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("test")
    //@HystrixCommand(fallbackMethod = "test2")
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    @HystrixCommand()
    public String test1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String url = "http://" + host + ":" + serviceInstance.getPort() + "hello";
        String s = restTemplate.getForObject(url, String.class);
        return "test" + s;
    }

    //服务降级
    public String test2() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String url = "http://" + host + ":" + serviceInstance.getPort() + "hello";
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("chao'shi");
        return "服务器太繁忙了，555" + s;
    }

    @RequestMapping("test3")
    @HystrixCommand()
    public String test3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String url = "http://" + host + ":" + serviceInstance.getPort() + "hello";
        String s = restTemplate.getForObject(url, String.class);
        return "test3" + "/n" + s;
    }

    //熔断
    @RequestMapping("test4/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })
    public String test4(@PathVariable("id") int id) {
        if (id % 2 == 0) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String url = "http://" + host + ":" + serviceInstance.getPort() + "hello";
        String s = restTemplate.getForObject(url, String.class);
        return "test4" + "/n" + s;
    }
}
