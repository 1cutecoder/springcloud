package cute.coder.eurekaclient1.service;

import cute.coder.eurekaclient1.bean.Admin;

import java.util.List;

/**
 * Created by cute coder
 * 2019/8/31 16:09
 */
public interface AdminService {
    List<Admin> getAdminByName(String userName);
}
