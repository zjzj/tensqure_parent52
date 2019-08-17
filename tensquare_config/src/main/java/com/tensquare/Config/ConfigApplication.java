package com.tensquare.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Zj
 * @date 2019/8/17 11:11
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigApplication.class);
  }
}
