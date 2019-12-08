package com.test;

import com.lp.bos.model.User;
import com.lp.bos.service.UserService;
import com.lp.bos.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Demo02 {

    @Autowired
    private UserService userService;
    //测试Dao
    @Test
    public void test(){
        //1.创建User
        User user = new User();
        user.setUsername("LiuYi");
        user.setPassword(MD5Utils.text2md5("123456"));

        //2.保存
        userService.save(user);
    }
}
