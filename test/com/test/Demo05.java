package com.test;

import com.lp.bos.dao.FunctionDao;
import com.lp.bos.model.Function;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Demo05 {

    @Autowired
    private FunctionDao functionDao;
    @Test
    public void test1() throws Exception {

        List<Function> functions = functionDao.findListByUserId("40283e816eba3bd2016eba3bd4060000");
        System.out.println("size:" + functions.size());
        for(Function f : functions){
            System.out.println(f.getId() + ":" + f.getName());
        }
    }

    @Autowired
    private RuntimeService rs;

    @Test
    public void test2(){
        //报销
        Map<String,Object> info = new HashMap<String,Object>();
        info.put("bxyy","出差-广州到深圳的飞机票");//报销原因
        info.put("bxje","3688.00");//报销原因
        info.put("employee","LiuYi");
        rs.startProcessInstanceByKey("bxlc",info);
    }

    @Autowired
    private TaskService ts;
    @Test
    public void test3(){
        Map<String,Object> info = new HashMap<String,Object>();
        info.put("manager","PLuo");
        ts.complete("407",info);
    }
}
