package com.imock.mmall.validate;

import net.bytebuddy.implementation.bind.annotation.This;
import org.springframework.util.StringUtils;
import sun.plugin2.message.Message;

import java.security.Key;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 校验器实现.
 * @author: Chen Kj
 * @date: 2018/8/23 17:09
 * @version: 1.0
 */
public class BaseValidator implements Validator {
    private Map<String, String> errorMap;

    public BaseValidator() {
        errorMap = new HashMap<>();
    }

    @Override
    public Validator validateIsNull(String property, Object value) {
        if (property == null || value == null) {
            errorMap.put(property, "为空");
        }
        return this;
    }

    @Override
    public Validator validateIsEmpty(String property, Object value) {
        if (property == null && StringUtils.isEmpty(value)) {
            errorMap.put(property, "为空");
        }
        return this;
    }

    @Override
    public Validator validateIsEmpty(String property, List list) {
        return null;
    }

    @Override
    public Validator validateInArray(String property, String value, Object[] array) {
        return null;
    }

    @Override
    public Validator validateEquals(String property, String a, String b) {
        if (property == null || !a.equals(b)) {
            String message = MessageFormat.format("属性值与目标值不匹配 a: {0}, b: {1}", a, b);
            errorMap.put(property, message);
        }

        return this;
    }

    @Override
    public String getOneError() {
        if (errorMap != null && errorMap.size() > 0) {
            Iterator<String> iterator = errorMap.keySet().iterator();

            while (iterator.hasNext()) {
                String property = iterator.next();
                return property + errorMap.get(property);
            }
        }

        return null;
    }

    @Override
    public String getAllError() {
        if (errorMap != null && errorMap.size() > 0) {
            StringBuilder builder = new StringBuilder();

            Iterator<String> iterator = errorMap.keySet().iterator();
            while (iterator.hasNext()) {
                String property = iterator.next();
                String message = errorMap.get(property);

                builder.append(property + message + ";");
            }

            if (builder.length() > 0) {
                return builder.toString();
            }
        }

        return null;
    }

    @Override
    public Map<String, String> getError() {
        return errorMap;
    }
}
