package com.myself.study.service.impl;

import com.myself.study.dao.SysUserMapper;
import com.myself.study.entity.SysUser;
import com.myself.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserMapper userMapper;

    /**
     * 添加用户(通过MD5 salt加密)
     *
     * @param user
     * @param password
     * @param salt
     */
    @Transactional
    public void addUserByMd5(String user, String password, String salt) {
        userMapper.addUserByMd5(user,password,salt);
    }

    /**
     * 添加用户
     *
     * @param user
     * @param password
     */
    @Transactional
    public void addUserByNormal(String user, String password){
        userMapper.addUserByNormal(user,password);
    }


    /**
     * 通过用户名称获取用户相关信息
     * @param userName
     * @return
     */
    @Transactional
    public SysUser getByUsername(String userName) {
        return userMapper.getByUsername(userName);
    }

    /**
     * 通过用户名称获得用户相关角色
     * @param userName
     * @return
     */
    @Transactional
    public Set<String> getRoles(String userName) {
        return userMapper.getRoles(userName);
    }

    /**
     * 获取是否允许
     * @param userName
     * @return
     */
    @Transactional
    public Set<String> getPermissions(String userName) {
        return userMapper.getPermissions(userName);
    }
}
