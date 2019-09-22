package cute.coder.eureka_ribbon.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cute coder
 * 2019/9/21 12:39
 */
@FeignClient("eureka-client")
public interface ConsumerClient {
    @RequestMapping("hello")
    @ResponseBody
    public String hello();
}
