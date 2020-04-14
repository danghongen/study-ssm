package com.myself.study.dao;

import com.myself.study.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SysUserMapper {

    /**
     * 添加用户（通过MD5、salt加密）
     * @param userName
     * @param password
     * @param salt
     */
    void addUserByMd5(@Param("userName") String userName, @Param("password") String password, @Param("salt") String salt);

    /**
     * 添加用户（明文添加）
     * @param userName
     * @param password
     */
    void addUserByNormal(@Param("userName") String userName,@Param("password") String password);

    /**
     * 获取用户通过用户名称
     * @param userName
     * @return
     */
    SysUser getByUsername(@Param("userName") String userName);

    /**
     * 获取是否允许
     * @param userName
     * @return
     */
    Set<String> getPermissions(@Param("userName") String userName);

    /**
     * 获取角色
     * @param userName
     * @return
     */
    Set<String> getRoles(@Param("userName") String userName);

}