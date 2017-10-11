package com.carfree.app.support;

import com.alibaba.fastjson.JSONObject;
import com.artist.common.entity.JSONObjectResult;
import com.artist.common.utils.PropertiesLoader;
import com.artist.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 * web工具类
 * Created by liwenlong on 2017/4/5.
 */
public class WebUtil  {

    private static Logger logger = LoggerFactory.getLogger(WebUtil.class);

    public final static String KEY_START_SECURITY_ON = "StartSecurity";
    private static String secretkey = PropertiesLoader.getValue("secretkey");


    /**
     * 请求数据加密
     */
    public static String getSign(Map<String, String> parameterMap) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        TreeSet<String> ts = new TreeSet<String>();
        ts.addAll(parameterMap.keySet());
        StringBuilder sb = new StringBuilder();
        for (String key : ts) {
            if(StringUtils.isNotEmpty(key)){
                if ("sign".equals(key)) continue;
                sb.append(key + "=" + parameterMap.get(key) + "&");
            }
        }
        sb.setLength(sb.length() - 1);
        // TODO  MD5  未加扰码
        return MD5Util.MD5Encode(String.valueOf(sb.toString()) + secretkey, "utf-8");

    }

    /**
     * 客户端请求加密处理
     * Created by liwenlong on 2017/4/5.
     */
    public static boolean checkSign(Map<String, String[]> parameterMap) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        Map<String, String> map = new HashMap<String,String>();
        TreeSet<String> ts = new TreeSet<String>();
        ts.addAll(parameterMap.keySet());
        for (String key : ts) {
            map.put(key,parameterMap.get(key)[0]);
        }

        String thisSign = getSign(map);
        boolean signBoolean = thisSign.equals(parameterMap.get("sign")[0].trim());
        return signBoolean;
    }

    /**
     * 响应客户端请求
     * Created by liwenlong on 2017/4/5.
     */
    public static void doJsonResponse( JSONObjectResult jsonResult) {
        HttpServletResponse response = getResponse();
        String result = JSONObject.toJSONString(jsonResult);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.println(result);
            pw.flush();
        } catch (IOException e) {
           logger.error("IOException",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    /**
     * 响应客户端请求
     * Created by liwenlong on 2017/4/5.
     */
    public static void doJsonResponse(String str) {
        HttpServletResponse response = getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.println(str);
            pw.flush();
        } catch (IOException e) {
            logger.error("IOException",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void doByteArrayResponse(HttpServletResponse response, byte[] data) throws Exception {
        OutputStream outputStream = null;
        try {
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentLength(data.length);
            outputStream = response.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest(){
        //获取 request 对象。
        ServletRequestAttributes content = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        return content.getRequest();
    }
    /**
     * 获取response
     * @return
     */
    public static HttpServletResponse getResponse(){
        //获取 response对象。
        ServletRequestAttributes content = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        return content.getResponse();
    }

    /**
     * 获取当前服务所在IP
     */
    public static String getLocalIp(){
        final String LOCAL_IP = "127.0.0.1";
        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
           logger.error(e.getMessage(),e);
           return LOCAL_IP;
        }
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements())
        {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address)
                {
                    return ip.getHostAddress();
                }
            }
        }
        return LOCAL_IP;
    }

}
