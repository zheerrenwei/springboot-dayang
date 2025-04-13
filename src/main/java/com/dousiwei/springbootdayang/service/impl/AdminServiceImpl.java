package com.dousiwei.springbootdayang.service.impl;

import com.dousiwei.springbootdayang.mapper.AdminAnMapper;
import com.dousiwei.springbootdayang.mapper.AdminMapper;
import com.dousiwei.springbootdayang.pojo.dto.AdminDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminLoginDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminPageDTO;
import com.dousiwei.springbootdayang.pojo.dto.AdminUpdateDTO;
import com.dousiwei.springbootdayang.pojo.eneity.Admin;
import com.dousiwei.springbootdayang.result.PageResult;
import com.dousiwei.springbootdayang.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper AdminMapper;
    @Autowired
    private AdminAnMapper adminAnMapper;
    //管理员登陆
    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) {
        String adminName = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        //根据用户名查询数据库中的内容
        Admin admin = AdminMapper.getByAdminName(adminName);
        //判断管理员是否存在
        if (admin == null) {
            //管理员不存在
            throw new ArithmeticException("管理员不存在");
        }
        //判断密码是否正确
        if (!admin.getPassword().equals(password)) {
            //密码错误
            throw new ArithmeticException("密码错误");
        }
        //判断账号是否被禁用
        if (admin.getRole().equals("super")) {
            //帐号被禁用
            throw new ArithmeticException("帐号被禁用");
        }
        return admin;
    }
    //添加管理员
    @Override
    public void addAdmin(AdminDTO adminDTO) {
        Admin admin=new Admin();
        //将adminDTO中的数据拷贝到admin中
        BeanUtils.copyProperties(adminDTO,admin);
        //添加默认角色
        admin.setRole("normal");
        //记录创建时间
        admin.setCreateTime(LocalDateTime.now());
        //插入数据库
        AdminMapper.insert(admin);
    }
    //分页查询
    @Override
    public PageResult page(AdminPageDTO adminPageDTO) {
        //开始分页查询
        PageHelper.startPage(adminPageDTO.getPage(),adminPageDTO.getPagesize());
        Page<Admin> page=AdminMapper.page(adminPageDTO);

        long total = page.getTotal();
        List<Admin> records = page.getResult();

        return new PageResult(total,records);
    }
    //启用或禁用管理员
    @Override
    public void role(Integer status, int adminId) {
        String role = new String();
        if (status == 1){
            role = "normal";
        }else if (status == 0){
            role = "super";
        }
        Admin admin=Admin.builder()
                .role(role)
                .adminId(adminId)
                .build();
        AdminMapper.update(admin);
    }
    //根据id查询管理员信息
    @Override
    public Admin getById(int adminId) {
        Admin admin = AdminMapper.getById(adminId);
        return admin;
    }
    //修改管理员信息
    @Override
    public void update(AdminUpdateDTO adminUpdateDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminUpdateDTO,admin);

        AdminMapper.update(admin);
    }
    //删除管理员
    @Override
    public void delete(int adminId) {
        AdminMapper.delete(adminId);
        adminAnMapper.deleteByAdminId(adminId);
    }
}
