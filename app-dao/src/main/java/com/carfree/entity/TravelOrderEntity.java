package com.carfree.entity;

import com.artist.common.annotation.FieldNameAnnotation;
import com.artist.common.annotation.TableNamePrefixAnnotation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Title 行程订单entity
 * @Description
 * @Author yongSen.wang
 * @Create 2017-05-05 17:45
 * @Version V1.0
 */
public class TravelOrderEntity extends BaseEntity{

    /**
     * 表主键
     */
    private Long orderId;
    /**
     * 行程订单编号
     */
    private String orderCode;
    /**
     * 汽车表主键
     */
    private Long carId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 事故状态
     */
    private Integer accidentStatus;
    /**
     * 违章状态
     */
    private Integer infringeStatus;
    /**
     * 1已预约、2已取消、3已提车、5待支付（已还车）、6已支付、7已完成
     */
    private Integer status;
    /**
     * 预约时间
     */
    private Date reserveTime;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 取消预约时间
     */
    private Date cancelTime;
    /**
     * 提车时间
     */
    private Date pickCarTime;
    /**
     * 还车时间
     */
    private Date returnCarTime;
    /**
     *起点站点id
     */
    private Integer startStatId;
    /**
     * 结束站点id
     */
    private Integer endStatId;
    /**
     * 起点站点名称
     */
    private String startStatName;
    /**
     * 终点站点名称
     */
    private String endStatName;
    /**
     * 使用时长
     */
    private Integer serviceTime;
    /**
     * 订单总金额
     */
    private BigDecimal total;
    /**
     * 1 支付宝 2 微信，3 充值卡
     */
    private Integer payType;
    /**
     * 第三方订单号
     */
    private String thirdpartyOrderCode;
    /**
     * 是否接力
     */
    private Integer isRelay;
    /**
     * 支付完成时间
     */
    private Date payTime;
    /**
     * 还车确认状态
     */
    private Integer returnStatus;
    /**
     * 订单类型 0 普通订单  1 周租订单
     */
    private Integer orderType;
    /**
     * 计费规则id
     */
    private String rateId;
    /**
     * 还车时电量
     */
    private Integer carBattery;
    /**
     * 明细交易流水号
     */
    private String transactionNumber;
    /**
     *开始里程（单位米）
     */
    private Integer beginKm;
    /**
     *结束里程（单位米）
     */
    private Integer endKm;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 用户账号（手机号）
     */
    private String userAccount;

    /**
     * 下单时间开始时间:预约时间
     */
    private String reserveTimeBegin;
    /**
     * 下单时间结束时间:预约时间
     */
    private String reserveTimeEnd;
    /**
     * 订单金额开始金额
     */
    private BigDecimal totalBegin;
    /**
     * 订单金额结束金额
     */
    private BigDecimal totalEnd;
    /**
     * 行程行驶距离
     */
    private Integer distance;
    /**
     * 实付金额
     */
    private BigDecimal actualMoney;
    /**
     * 车型名称
     */
    private String ccName;
    /**
     * 优惠券抵扣金额
     */
    private BigDecimal couponMoney;
    /**
     * 预计支付金额
     */
    private BigDecimal forecastMoney;

    /**
     * 车型ID
     */
    private Integer ccId;
    /**
     * 违章时间
     */
    private Date occurrenceDate;
    /**
     * 车型Ids
     */
    private List<Integer> ccIds;

    /**
     * 预付周期个数
     */
    private Integer prepayPeriod;

    /**
     * 预付费用（单位：元）
     */
    private BigDecimal prepayAmount;

    /**
     * 是否预付标志  0 未预付，1 已预付
     */
    private Integer prepayFlag;

    /**
     * 预付费支付方式 1 支付宝，2 微信，3 充值卡
     */
    private Integer prepayType;

    /**
     *请求来源 缴费列表:1
     */
    private Integer searchSource;
    /**
     *是否已分享默认为0，0：否、1：是
     */
    private Integer hasShare;

    /**
     * 调价id（如果是0说明没有调价）
     */
    private Long adjustconfId;

    /**
     * 能耗费配置表主键id， 默认0没有能耗费
     */
    private Long energyId;

    /**
     * 城市编码
     */
    private Integer cityCode;

    /**
     * 能耗量（单位：油为升，电为千瓦时 ）
     */
    private Integer consumeNum;

    /**
     * 能耗费（单位：元）
     */
    private BigDecimal consumeFee;

    public Integer getConsumeNum() {
        return consumeNum;
    }

    public void setConsumeNum(Integer consumeNum) {
        this.consumeNum = consumeNum;
    }

    public BigDecimal getConsumeFee() {
        return consumeFee;
    }

    public void setConsumeFee(BigDecimal consumeFee) {
        this.consumeFee = consumeFee;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Long getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Long energyId) {
        this.energyId = energyId;
    }

    public Long getAdjustconfId() {
        return adjustconfId;
    }

    public void setAdjustconfId(Long adjustconfId) {
        this.adjustconfId = adjustconfId;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAccidentStatus() {
        return accidentStatus;
    }

    public void setAccidentStatus(Integer accidentStatus) {
        this.accidentStatus = accidentStatus;
    }

    public Integer getInfringeStatus() {
        return infringeStatus;
    }

    public void setInfringeStatus(Integer infringeStatus) {
        this.infringeStatus = infringeStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getPickCarTime() {
        return pickCarTime;
    }

    public void setPickCarTime(Date pickCarTime) {
        this.pickCarTime = pickCarTime;
    }

    public Date getReturnCarTime() {
        return returnCarTime;
    }

    public void setReturnCarTime(Date returnCarTime) {
        this.returnCarTime = returnCarTime;
    }

    public Integer getStartStatId() {
        return startStatId;
    }

    public void setStartStatId(Integer startStatId) {
        this.startStatId = startStatId;
    }

    public Integer getEndStatId() {
        return endStatId;
    }

    public void setEndStatId(Integer endStatId) {
        this.endStatId = endStatId;
    }

    public String getStartStatName() {
        return startStatName;
    }

    public void setStartStatName(String startStatName) {
        this.startStatName = startStatName;
    }

    public String getEndStatName() {
        return endStatName;
    }

    public void setEndStatName(String endStatName) {
        this.endStatName = endStatName;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getThirdpartyOrderCode() {
        return thirdpartyOrderCode;
    }

    public void setThirdpartyOrderCode(String thirdpartyOrderCode) {
        this.thirdpartyOrderCode = thirdpartyOrderCode;
    }

    public Integer getIsRelay() {
        return isRelay;
    }

    public void setIsRelay(Integer isRelay) {
        this.isRelay = isRelay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public Integer getCarBattery() {
        return carBattery;
    }

    public void setCarBattery(Integer carBattery) {
        this.carBattery = carBattery;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Integer getBeginKm() {
        return beginKm;
    }

    public void setBeginKm(Integer beginKm) {
        this.beginKm = beginKm;
    }

    public Integer getEndKm() {
        return endKm;
    }

    public void setEndKm(Integer endKm) {
        this.endKm = endKm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getReserveTimeBegin() {
        return reserveTimeBegin;
    }

    public void setReserveTimeBegin(String reserveTimeBegin) {
        this.reserveTimeBegin = reserveTimeBegin;
    }

    public String getReserveTimeEnd() {
        return reserveTimeEnd;
    }

    public void setReserveTimeEnd(String reserveTimeEnd) {
        this.reserveTimeEnd = reserveTimeEnd;
    }

    public BigDecimal getTotalBegin() {
        return totalBegin;
    }

    public void setTotalBegin(BigDecimal totalBegin) {
        this.totalBegin = totalBegin;
    }

    public BigDecimal getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(BigDecimal totalEnd) {
        this.totalEnd = totalEnd;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public BigDecimal getForecastMoney() {
        return forecastMoney;
    }

    public void setForecastMoney(BigDecimal forecastMoney) {
        this.forecastMoney = forecastMoney;
    }

    public List<Integer> getCcIds() {
        return ccIds;
    }

    public void setCcIds(List<Integer> ccIds) {
        this.ccIds = ccIds;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public Integer getSearchSource() {
        return searchSource;
    }

    public void setSearchSource(Integer searchSource) {
        this.searchSource = searchSource;
    }

    public Integer getHasShare() {
        return hasShare;
    }

    public void setHasShare(Integer hasShare) {
        this.hasShare = hasShare;
    }

    public Integer getPrepayPeriod() {
        return prepayPeriod;
    }

    public void setPrepayPeriod(Integer prepayPeriod) {
        this.prepayPeriod = prepayPeriod;
    }

    public BigDecimal getPrepayAmount() {
        return prepayAmount;
    }

    public void setPrepayAmount(BigDecimal prepayAmount) {
        this.prepayAmount = prepayAmount;
    }

    public Integer getPrepayFlag() {
        return prepayFlag;
    }

    public void setPrepayFlag(Integer prepayFlag) {
        this.prepayFlag = prepayFlag;
    }

    public Integer getPrepayType() {
        return prepayType;
    }

    public void setPrepayType(Integer prepayType) {
        this.prepayType = prepayType;
    }
}
