package com.bjyada.demo.controller;

import com.bjyada.demo.entity.DecryData;
import com.bjyada.demo.service.DecryDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class DecryDataControllerTest {
    @Resource
    DecryDataService decryDataService;
    @Test
    public void save() throws Exception {
        for(int i=0;i<10;i++){
            DecryData DecryData=new DecryData();
            DecryData.setValue(i+11);
            DecryData.setTime(new Long(2));
            decryDataService.save(DecryData);
        }


    }

    @Test
    public void delete() throws Exception {
        decryDataService.delete(10);
    }

    @Test
    public void findAll() throws Exception {
        List<DecryData> list=decryDataService.findAll();
        for (DecryData decry:list) {
            System.out.println(decry);
        }
    }
    @Test
    public void findPage() throws Exception {
       Page<DecryData> page=decryDataService.findAll(2,3);
        System.out.println("getTotalElements==============="+page.getTotalElements());
        System.out.println("getTotalPages==============="+page.getTotalPages());
        System.out.println("getgetNumber=============="+page.getNumber());
        System.out.println("getgetNumberOfElements==============="+page.getNumberOfElements());
        for (DecryData decry:page.getContent()) {
            System.out.println(decry);
        }
    }

}