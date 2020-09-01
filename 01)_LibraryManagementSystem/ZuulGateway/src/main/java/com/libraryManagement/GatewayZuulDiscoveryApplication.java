package com.libraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.libraryManagement.filter.ErrorFilter;
import com.libraryManagement.filter.PostFilter;
import com.libraryManagement.filter.PreFilter;
import com.libraryManagement.filter.RouteFilter;

@EnableEurekaClient // use this annotation when registration center is eureka  and Can also be used@EnableDiscoveryClient
@EnableDiscoveryClient //--- is used when registration center is not eureka ,but such as consul, zookeeper, etc., can only be used@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class GatewayZuulDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulDiscoveryApplication.class, args);
	}
	
	//below filters are optional not necessary to write
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
