package com.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yxx
 * @date 2021/7/19 14:47
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
        String lbsMessage = "/";

        // 解析经纬度保留两位小数
        String latitude = ""; // 纬度
        String longitude = ""; // 经度
        String latitudeSaveTow = "";// 纬度保留两位小数
        String longitudeSaveTow = "";// 经度保留两位小数
        if (!isNull(lbsMessage)) {
            String[] lbsArray = lbsMessage.split("/");
            if (lbsArray.length == 2) {
                latitude = lbsArray[0];
                longitude = lbsArray[1];
                BigDecimal decimalLatitude = new BigDecimal(latitude);
                BigDecimal decimalLongitude = new BigDecimal(longitude);
                decimalLatitude = decimalLatitude.setScale(2, BigDecimal.ROUND_HALF_UP);
                decimalLongitude = decimalLongitude.setScale(2, BigDecimal.ROUND_HALF_UP);
                latitudeSaveTow = String.valueOf(decimalLatitude);
                longitudeSaveTow = String.valueOf(decimalLongitude);
            }
        }
        System.out.println(isNull(latitudeSaveTow) ? "" : latitudeSaveTow + "/" + longitudeSaveTow);
        System.out.println(false ? "0": "1");
    }
    public static boolean isNull(String param) {
        if (param == null || param.length() == 0) {
            return true;
        }
        return false;
    }
}
