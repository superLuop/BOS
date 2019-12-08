package com.lp.bos.web.realm;

import com.lp.bos.dao.FunctionDao;
import com.lp.bos.dao.UserDao;
import com.lp.bos.model.Function;
import com.lp.bos.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BOSRealm extends AuthorizingRealm{

    /**
     * 权限-与角色权关
     * @param principalCollection
     * @return
     */
    @Autowired
    private FunctionDao functionDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        User loginUser = (User) principalCollection.getPrimaryPrincipal();
        //根据用户id查询权限
        List<Function> functions = null;
        //设置admin为超级管理员
        if ("admin".equals(loginUser.getUsername())){
            functions = functionDao.findAll();
        }else {
            functions = functionDao.findListByUserId(loginUser.getId());
        }
        //添加权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Function function : functions){
            simpleAuthorizationInfo.addStringPermission(function.getCode());
        }
//        simpleAuthorizationInfo.addStringPermission("staff_add");
//        simpleAuthorizationInfo.addStringPermission("staff_delete");
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Autowired
    private UserDao userDao;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //查询数据，并存放在realm
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取用户名
        String username = usernamePasswordToken.getUsername();
        //根据用户名查询用户
        User dbUser = userDao.findByUsername(username);
        if (dbUser != null){
            /**
             * Object principal, 把数据库查询的对象
             * Object credentials,证书：写密码自动验证，查询出来的密码
             * String realmName,当前的类名
             */
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),this.getClass().getSimpleName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
