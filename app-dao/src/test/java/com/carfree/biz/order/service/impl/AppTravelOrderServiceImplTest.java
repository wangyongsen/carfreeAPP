package com.carfree.biz.order.service.impl;


import com.alibaba.fastjson.JSON;
import com.carfree.biz.BaseTest;
import com.carfree.dao.TravelOrderDao;
import com.carfree.entity.TravelOrderEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppTravelOrderServiceImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AppTravelOrderServiceImplTest.class);

    @Autowired
    private TravelOrderDao travelOrderDao;

    @Test
    public void testGetTravelOrderList()  {
        List<TravelOrderEntity> travelOrderEntities =  travelOrderDao.testGetTravelOrderList();
        System.out.println("result:"+ JSON.toJSONString(travelOrderEntities));
    }




}