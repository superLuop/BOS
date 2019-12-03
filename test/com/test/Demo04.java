package com.test;

import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;

import java.util.List;

public class Demo04 {

    @Test
    public void test1() throws Exception {

        //访问另一个项目的数据，使用远程调用Hessian
        //1.创建一个代理对象
        HessianProxyFactory factory = new HessianProxyFactory();

        CustomerService customerService = (CustomerService) factory.create(CustomerService.class,"http://localhost:8082/HessionServer_war_exploded/hessian/customer");

        List<Customer> list = customerService.findAll();
        System.out.println(list);
    }
}
