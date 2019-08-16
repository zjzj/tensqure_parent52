package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author Zj
 * @date 2019/8/16 15:07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ManagerApplication.class);
  }

  @Bean
  public JwtUtil jwtUtil(){
    return new JwtUtil();
  }
}
