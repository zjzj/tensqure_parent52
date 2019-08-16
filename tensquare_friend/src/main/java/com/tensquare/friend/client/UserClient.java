package com.tensquare.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zj
 * @date 2019/8/15 17:32
 */
@FeignClient("tensquare-user")
public interface UserClient {

  @RequestMapping(value = "/user/{userid}/{friendid}/{x}",method = RequestMethod.PUT)
  public void updateFansCountAndFollowCount(@PathVariable("userid") String userid, @PathVariable("friendid") String friendid, @PathVariable("x") int x);

}
