package com.tensquare.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author Zj
 * @date 2019/8/14 21:06
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class FriendApplication {

  public static void main(String[] args) {
    System.setProperty("jasypt.encryptor.password","wqyzj11.");
    SpringApplication.run(FriendApplication.class);
  }

  @Bean
  public JwtUtil jwtUtil(){
    return new JwtUtil();
  }

}
