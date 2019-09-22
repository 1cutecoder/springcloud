package cute.coder.eurekaclient.controller;

import cute.coder.eurekaclient.bean.Admin;
import cute.coder.eurekaclient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cute coder
 * 2019/8/22 20:46
 */
@Controller
public class HelloController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        List<Admin> searchAdmin = adminService.getAdminByName("admin123");
        System.out.println("eureka-client2 has bean called");
        return searchAdmin.toString();
    }
}
