package com.carfree.app.rest.order;

import com.artist.common.entity.JSONObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 行程订单Controller
 * Created by liuweiqiang on 2017-05-12.
 */
@Controller
@RequestMapping("/order")
public class TravelOrderController  {

    private static final Logger logger = LoggerFactory.getLogger(TravelOrderController.class);


    /**
     * 校验租车权限
     */
    @RequestMapping("/verifyUserRentalAuth.htm")
    @ResponseBody
    public JSONObjectResult verifyUserRentalAuth(String tokenId, String vinCode, String cityCode) {



        //返回结果
            return JSONObjectResult.success("ok");


    }




}