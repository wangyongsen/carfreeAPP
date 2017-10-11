package com.carfree.dao;


import com.alibaba.fastjson.JSON;
import com.carfree.BaseTest;
import com.carfree.entity.TravelOrderEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppDaoTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(AppDaoTest.class);

    @Autowired
    private TravelOrderDao travelOrderDao;

    @Test
    public void testGetTravelOrderList()  {

        List<TravelOrderEntity> travelOrderEntities =  travelOrderDao.testGetTravelOrderList();
        System.out.println("result:"+ JSON.toJSONString(travelOrderEntities));
    }




}