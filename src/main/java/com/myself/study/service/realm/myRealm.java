package com.myself.study.service.realm;

import com.myself.study.entity.SysUser;
import com.myself.study.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class myRealm extends AuthorizingRealm {

//  注解Resource与Autowired类似但不相同
    @Autowired
    UserService userService;

    /**
     * 为当前登录成功的用户授予权限和角色，已经登录成功了
     */

    /*参数解释：
    * PrincipalCollection：是一个身份集合，而方法getPrimaryPrincipal则是得到主要的身份，需要注意的是，如果只有一个Principal则直接返回，如果有多个，则返回第一个（因为内部使用map储存，所以可以认为是返回任意一个）
    * SimpleAuthorizationInfo：用于聚合授权信息
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String) principalCollection.getPrimaryPrincipal();//获取用户名
        SimpleAuthorizationInfo authenticationInfo=new SimpleAuthorizationInfo();
        authenticationInfo.setRoles(userService.getRoles(username));//set角色字符串信息
        authenticationInfo.setStringPermissions(userService.getPermissions(username));//set权限字符串信息
        return authenticationInfo;
    }


    /**
     * 验证当前登陆的用户，获取认证信息
     */
    /*参数解释：
    * AuthenticationToken：AuthenticationToken 用于收集用户提交的身份（如用户名）及凭据（如密码）
    *AuthenticationInfo：AuthenticationInfo对象中存储的是主体（Subject）的身份认证信息。Shiro会调用CredentialsMatcher对象的doCredentialsMatch方法
                        对AuthenticationInfo对象和AuthenticationToken进行匹配。匹配成功则表示主体（Subject）认证成功，否则表示认证失败。。
    *在认证成功以后进行权限与角色的查询，需要创建SimpleAuthenticationInfo对象。
    *   SimpleAuthenticationInfo：SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
userInfo, //用户名–此处传的是用户对象
userInfo.getPassword(), //密码—从数据库中获取的密码
salt,//盐–用于加密密码对比，–获取的经验：为了防止两用户的初始密码是一样的，
       四个参数，防止两用户可能初始密码相同时候用，token 用simplehash（四个参数的构造） 加密默认用了MD5 迭代一次加密，
       info中在密码比对调用new SimpleHash(String algorithmName, Object source）这个实例化对象默认迭代一次了，
       所以当你用三个参数加密时候可能两 个初始密码相同人的就没能区别开 （因此realm中密码要从数据库的查的原因），通过设置reaml 中credentialsMatcher 属性的各项属性可实现
getName() //当前的realm名
); */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();//获取用户名
        String password= Arrays.toString(token.getPassword());
        SysUser user=userService.getByUsername(username);
        if (user!=null){
            if (!password.equals(user.getPassword())){
                return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"myRealm");
            }else {
                throw new AccountException("密码错误！");
            }

        }else {
            throw new AccountException("账号不存在");
        }
    }
}
