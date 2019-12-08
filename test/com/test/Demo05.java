package com.test;

import com.lp.bos.dao.FunctionDao;
import com.lp.bos.model.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
}
