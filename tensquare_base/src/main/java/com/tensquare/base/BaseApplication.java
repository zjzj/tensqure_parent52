package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author Zj
 * @date 2019/7/21 14:53
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {

  public static void main(String[] args) {
    System.setProperty("jasypt.encryptor.password","wqyzj11.");
    SpringApplication.run(BaseApplication.class, args);
  }

  @Bean
  public IdWorker idWorker(){
    return new IdWorker(1,1);
  }

}
