package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author Zj
 * @date 2019/7/31 22:38
 */
@SpringBootApplication
public class SpitApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpitApplication.class);
  }

  @Bean
  public IdWorker idWorker(){
    return new IdWorker();
  }

}
