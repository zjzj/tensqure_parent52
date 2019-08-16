package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author Zj
 * @date 2019/8/16 10:40
 */
@Component
public class BaseClientImpl implements BaseClient {
  @Override
  public Result findById(String labelId) {
    return new Result(false, StatusCode.ERROR,"经过了熔断器");
  }
}
