package com.imock.mmall;

import com.imock.mmall.utils.BigDecimalUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author: Chen Kj
 * @date: 2019/2/27 17:26
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
public class BigDecimalUtilTest {


    @Test
    public void testAdd() {
        double a = 2.23;
        double b = 2.77;

        System.out.println(BigDecimalUtil.add(a, b));
    }

}
