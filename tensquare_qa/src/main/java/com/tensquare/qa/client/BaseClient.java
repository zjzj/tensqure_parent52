package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zj
 * @date 2019/8/14 18:22
 */
@Component
@FeignClient(value = "tensquare-base",fallback = BaseClientImpl.class)
public interface BaseClient {
  @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
  public Result findById(@PathVariable("labelId") String labelId);
}
