package com.pangtudy.conferenceapi.core.config;

import com.netflix.appinfo.AmazonInfo;

import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaInstanceConfig {
	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
		EurekaInstanceConfigBean bean = new EurekaInstanceConfigBean(inetUtils);
		AmazonInfo amazonInfo = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		bean.setDataCenterInfo(amazonInfo);
		return bean;
	}
}
