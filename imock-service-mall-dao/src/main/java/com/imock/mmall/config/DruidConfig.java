package com.imock.mmall.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid数据源配置。
 * @author: Chen Kj
 * @date: 2018/8/21 14:19
 * @version: 1.0
 */

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druid() {
        return new DruidDataSource();
    }


    /* ------------ 配置druid监控 ------------ */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        // 添加过滤规则。
        filterRegistrationBean.addUrlPatterns("/*");

        // 添加不需要过滤的信息
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,*.png,*.jpg,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParams);
        return filterRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String, String> initParams = new HashMap<>();

        // 白名单
        initParams.put("allow", "192.168.249.112,127.0.0.1");

        // 黑名单
        initParams.put("deny", "192.168.10.1");

        // 登录账号密码
        initParams.put("loginUsername", "druid");
        initParams.put("loginPassword", "123456");

        // 是否能够重置数据.
        initParams.put("resetEnable", "false");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }
}


