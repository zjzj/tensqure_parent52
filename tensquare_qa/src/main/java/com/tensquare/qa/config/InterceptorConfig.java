package com.tensquare.qa.config;

import com.tensquare.qa.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Zj
 * @date 2019/8/13 22:38
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

  @Autowired
  private JwtInterceptor jwtInterceptor;

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtInterceptor)
      .addPathPatterns("/**")
      .excludePathPatterns("/**/login/**");
  }

}
