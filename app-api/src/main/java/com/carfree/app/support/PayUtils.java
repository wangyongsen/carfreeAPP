package com.carfree.app.support;

import com.alibaba.fastjson.JSONObject;
import com.artist.common.utils.PropertiesLoader;
import com.artist.common.utils.StringUtils;
import com.carfree.common.pay.AlipayUtils;
import com.carfree.common.pay.WechatUtils;
import com.carfree.user.account.api.AppUserPayorderRecordService;
import com.carfree.user.account.enums.UserPayorderRecordPayTypeEnum;
import com.carfree.user.account.enums.UserPayorderRecordTypeEnum;
import com.carfree.user.common.api.AppCommonService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwenlong on 2017/5/9.
 */
@Component
public class PayUtils {

    private static AppCommonService commonService;

    private static AppUserPayorderRecordService payService;

    //通过公共参数配置取得项目访问域名
    private  static String basePath = PropertiesLoader.getValue("basePath");

    //同步回调,用于查询当前单据状态
    private  static String returnUrl = basePath + "account/openPayInfo.htm";

    private static String ALIPAY_NOTIFYURL = basePath + "callback/alipay.htm";
    private static String WECHAT_NOTIFYURL = basePath + "callback/wechat.htm";

    static{
        commonService =ApplicationContextUtil.getBeanOfType(AppCommonService.class);
        payService =  ApplicationContextUtil.getBeanOfType(AppUserPayorderRecordService.class);
    }


    /**
     * 充值卡《支付宝签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     * @return
     */
    public static Map<String,Object> chargeAlipaySign(Long userId,String orderNo, String money, String body){
        //支付类型
        Integer alipayType = UserPayorderRecordPayTypeEnum.ALIPAY.getPayType();//支付宝类型
        Integer orderType = UserPayorderRecordTypeEnum.RECHARGE_CARD_RECHARGE.getType();//单据类型：充值卡充值
        //返回支付请求签名
        String subject = "购买的蓝充值卡";
//        String body = "购买充值卡金额："+money;
//        String notifyUrl = basePath + "recharge/rechargeAlipayCallback.htm";//异步回调
        String notifyUrl = ALIPAY_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,alipayType,userId,orderNo, new BigDecimal(money),body);
        String payInfo = AlipayUtils.clientSign(tradeNumber,subject,body,money,notifyUrl,returnUrl);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",payInfo);
        return  map;
     }

    /**
     * 充值卡《微信签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     */
    public static Map<String,Object> chargeWechatSign(Long userId,String orderNo, String money,String extendParam){
        //支付类型
        Integer wehcatType = UserPayorderRecordPayTypeEnum.WECHAT.getPayType();//微信支付类型
        Integer orderType = UserPayorderRecordTypeEnum.RECHARGE_CARD_RECHARGE.getType();//单据类型：充值卡充值
        //返回支付请求签名
        String subject = "购买的蓝充值卡";
        String body = "购买充值卡金额："+money;
//        String notifyUrl = basePath + "recharge/rechargeWechatCallback.htm";//异步回调
        String notifyUrl = WECHAT_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,wehcatType,userId,orderNo, new BigDecimal(money),body);
        Map<String, Object> rst = WechatUtils.clientSign(tradeNumber, subject, body, money, notifyUrl, WebUtil.getLocalIp(),extendParam);
        String payInfo = JSONObject.toJSONString(rst);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",JSONObject.parseObject(payInfo));
        return  map;
    }
    /**
     * 押金《支付宝签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     */
    public static Map<String,Object> depositAlipaySign(Long userId,String orderNo, String money, String body){
        //支付类型
        Integer alipayType = UserPayorderRecordPayTypeEnum.ALIPAY.getPayType();//支付宝类型
        Integer orderType = UserPayorderRecordTypeEnum.DEPOSIT_RECHARGE.getType();//单据类型：缴纳押金
        //返回支付请求签名
        String subject = "缴纳押金";
//        String body = "缴纳押金金额："+money;
//        String notifyUrl = basePath + "deposit/depositAlipayCallback.htm";//异步回调
        String notifyUrl = ALIPAY_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,alipayType,userId,orderNo, new BigDecimal(money),body);
        String payInfo = AlipayUtils.clientSign(tradeNumber,subject,body,money,notifyUrl,returnUrl);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",payInfo);
        return  map;
    }

    /**
     * 押金《微信签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     */
    public static Map<String,Object> depositWechatSign(Long userId,String orderNo, String money,String extendParam){
        //支付类型
        Integer wehcatType = UserPayorderRecordPayTypeEnum.WECHAT.getPayType();//微信支付类型
        Integer orderType = UserPayorderRecordTypeEnum.DEPOSIT_RECHARGE.getType();//单据类型：缴纳押金
        //返回支付请求签名
        String subject = "缴纳押金";
        String body = "缴纳金额："+money;
//        String notifyUrl = basePath + "deposit/depositWechatCallback.htm";//异步回调
        String notifyUrl = WECHAT_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,wehcatType,userId,orderNo, new BigDecimal(money),body);
        Map<String, Object> rst = WechatUtils.clientSign(tradeNumber, subject, body, money, notifyUrl, WebUtil.getLocalIp(),extendParam);
        String payInfo = JSONObject.toJSONString(rst);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",JSONObject.parseObject(payInfo));
        return  map;
    }

    /**
     * 行程订单《支付宝签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付总金额（如果有小费，包含小费金额）
     */
    public static Map<String,Object> orderAlipaySign(Long userId,String orderNo, String money, String body){
        //支付类型
        Integer alipayType = UserPayorderRecordPayTypeEnum.ALIPAY.getPayType();//支付宝类型
        Integer orderType = UserPayorderRecordTypeEnum.ORDER_PAYMENT.getType();//单据类型：行程订单费用

        //返回支付请求签名
        String subject = "行程订单支付";
//        String body = "行程订单支付金额："+money;
        String notifyUrl = ALIPAY_NOTIFYURL;//异步回调

        //添加第三方支付记录（注意：这里行程订单和小费调用第三方支付一次，只形成一条记录！）
        String tradeNumber = payService.appendUserPayorderRecord(orderType, alipayType, userId, orderNo, new BigDecimal(money), body);

        //调起支付宝APP
        String payInfo = AlipayUtils.clientSign(tradeNumber,subject,body,money,notifyUrl,returnUrl);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",payInfo);
        return  map;
    }

    /**
     * 行程订单《微信签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付总金额（如果有小费，包含小费金额）
     */
    public static Map<String,Object> orderWechatSign(Long userId,String orderNo, String money,String extendParam){

        //支付类型
        Integer wehcatType = UserPayorderRecordPayTypeEnum.WECHAT.getPayType();//微信支付类型
        Integer orderType = UserPayorderRecordTypeEnum.ORDER_PAYMENT.getType();//单据类型：订单支付

        //返回支付请求签名
        String subject = "行程订单支付";
        String body = "行程订单支付金额："+money;
        String notifyUrl = WECHAT_NOTIFYURL;//异步回调

        //用户行程订单支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,wehcatType,userId,orderNo, new BigDecimal(money),body);

        //调起微信支付APP
        Map<String, Object> rst = WechatUtils.clientSign(tradeNumber, subject, body, money, notifyUrl, WebUtil.getLocalIp(),extendParam);
        String payInfo = JSONObject.toJSONString(rst);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",JSONObject.parseObject(payInfo));
        return  map;
    }



    /**
     * 杂项缴费《支付宝签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     */
    public static Map<String,Object> incidentalsAlipaySign(Long userId,String orderNo, String money, String body){
        //支付类型
        Integer alipayType = UserPayorderRecordPayTypeEnum.ALIPAY.getPayType();//支付宝类型
        Integer orderType = UserPayorderRecordTypeEnum.MISCELLANEOUS_PAYMENT.getType();//单据类型：杂项缴费
        //返回支付请求签名
        String subject = "杂项缴费";
        String notifyUrl = ALIPAY_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,alipayType,userId,orderNo, new BigDecimal(money),body);
        String payInfo = AlipayUtils.clientSign(tradeNumber,subject,body,money,notifyUrl,returnUrl);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",payInfo);
        return  map;
    }

    /**
     * 杂项缴费《微信签名》
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付金额
     */
    public static Map<String,Object> incidentalsWechatSign(Long userId,String orderNo, String money,String extendParam){
        //支付类型
        Integer wehcatType = UserPayorderRecordPayTypeEnum.WECHAT.getPayType();//微信支付类型
        Integer orderType = UserPayorderRecordTypeEnum.MISCELLANEOUS_PAYMENT.getType();//单据类型：杂项缴费
        //返回支付请求签名
        String subject = "杂项缴费";
        String body = "杂项缴费："+money;
        String notifyUrl = WECHAT_NOTIFYURL;//异步回调
        //插入支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,wehcatType,userId,orderNo, new BigDecimal(money),body);
        Map<String, Object> rst = WechatUtils.clientSign(tradeNumber, subject, body, money, notifyUrl, WebUtil.getLocalIp(),extendParam);
        String payInfo = JSONObject.toJSONString(rst);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",JSONObject.parseObject(payInfo));
        return  map;
    }
    public static String getBasePath() {
        return basePath;
    }

    public static void setBasePath(String basePath) {
        PayUtils.basePath = basePath;
    }

    /**
     * 通用支付宝支付签名
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付总金额（如果有小费，包含小费金额）
     */
    public static Map<String,Object> alipaySign(Integer orderType, String orderNo, Long userId, String money, String subject, String extendParam){
        //支付类型
        Integer alipayType = UserPayorderRecordPayTypeEnum.ALIPAY.getPayType();
        //异步回调接口地址
        String notifyUrl = ALIPAY_NOTIFYURL;//异步回调
        //用户行程订单支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType, alipayType, userId, orderNo, new BigDecimal(money), extendParam);
        //生成并返回支付请求签名
        String payInfo = AlipayUtils.clientSign(tradeNumber,subject,extendParam,money,notifyUrl,returnUrl);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",payInfo);
        return  map;
    }

    /**
     * 通用微信支付签名
     * @param userId 会员ID
     * @param orderNo 业务单据号
     * @param money 支付总金额（如果有小费，包含小费金额）
     */
    public static Map<String,Object> wechatSign(Integer orderType, String orderNo, Long userId, String money, String subject, String body, String extendParam){
        //支付类型
        Integer wehcatType = UserPayorderRecordPayTypeEnum.WECHAT.getPayType();//微信支付类型
        //异步回调接口地址
        String notifyUrl = WECHAT_NOTIFYURL;
        //用户行程订单支付记录
        String tradeNumber = payService.appendUserPayorderRecord(orderType,wehcatType,userId,orderNo, new BigDecimal(money),extendParam);
        //生成并返回支付请求签名
        Map<String, Object> rst = WechatUtils.clientSign(tradeNumber, subject, body, money, notifyUrl, WebUtil.getLocalIp(),extendParam);
        String payInfo = JSONObject.toJSONString(rst);
        Map<String,Object> map = new HashMap<>();
        map.put("tradeNumber",tradeNumber);
        map.put("payInfo",JSONObject.parseObject(payInfo));
        return  map;
    }

}
