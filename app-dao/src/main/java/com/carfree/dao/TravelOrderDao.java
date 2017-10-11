package com.carfree.dao;

import com.artist.common.persistence.dao.BaseDao;
import com.carfree.entity.TravelOrderEntity;

import java.util.List;


/**
 * @Title 行程订单DAO
 * @Description
 * @Author yongSen.wang
 * @Create 2017-05-04 16:17
 * @Version V1.0
 */
public interface TravelOrderDao extends BaseDao {

    /**
     * 测试：获取多条订单数据
     *
     * @return
     */
    List<TravelOrderEntity> testGetTravelOrderList();
}
