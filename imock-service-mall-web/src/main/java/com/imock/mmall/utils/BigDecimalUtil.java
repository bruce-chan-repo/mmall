package com.imock.mmall.utils;

import java.math.BigDecimal;

/**
 * BigDecimalUtil
 * @author: Chen Kj
 * @date: 2019/2/27 17:23
 * @version: 1.0
 */
public class BigDecimalUtil {

    private BigDecimalUtil() {

    }

    /**
     * 添加
     * @param p1
     * @param p2
     * @return
     */
    public static BigDecimal add(double p1, double p2) {
        BigDecimal b1 = new BigDecimal(Double.toString(p1));
        BigDecimal b2 = new BigDecimal(Double.toString(p2));

        return b1.add(b2);
    }
}
