package com.myself.study.service;


import com.myself.study.entity.SysUser;

import java.util.Set;

public interface UserService {


    /**
     * 添加用户(通过MD5 salt加密)
     * @param user
     * @param password
     * @param salt
     */
    public void addUserByMd5(String user,String password,String salt) ;

    /**
     * 添加用户
     * @param user
     * @param password
     */
    public void addUserByNormal(String user,String password);

    public SysUser getByUsername(String userName);

    public Set<String> getRoles(String userName);

    public Set<String> getPermissions(String userName);

}
