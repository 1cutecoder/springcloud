package cute.coder.eurekaclient.service.impl;

import cute.coder.eurekaclient.bean.Admin;
import cute.coder.eurekaclient.mapper.AdminMapper;
import cute.coder.eurekaclient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cute coder
 * 2019/8/31 16:09
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Admin> getAdminByName(String userName) {
        return adminMapper.selectByUsername(userName);
    }
}
