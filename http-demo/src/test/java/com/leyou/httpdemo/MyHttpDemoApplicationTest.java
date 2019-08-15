package com.leyou.httpdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cute coder
 * 2019/8/16 0:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpDemoApplication.class)
public class MyHttpDemoApplicationTest {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void myTest1(){
        String forObject = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        System.out.println("forObject = " + forObject);
    }
}
