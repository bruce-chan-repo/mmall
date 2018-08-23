package com.imock.mmall.common;

import java.util.List;
import java.util.Map;

/**
 * 校验器
 *
 * @author: Chen Kj
 * @date: 2018/6/29 9:22
 * @version: 1.0
 */
public interface Validator {

    Validator validateIsNull(String property, Object value);

    Validator validateIsEmpty(String property, Object value);

    Validator validateIsEmpty(String property, List list);

    Validator validateInArray(String property, String value, Object[] array);

    Validator validateEquals(String property, String a, String b);

    String getOneError();

    String getAllError();

    Map<String, String> getError();

}
