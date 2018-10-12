package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/6/28 2:04
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class ConfigBean {

    private String userName;

    private String passWord;
}
