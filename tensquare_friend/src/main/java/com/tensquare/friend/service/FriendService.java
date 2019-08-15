package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zj
 * @date 2019/8/15 11:16
 */
@Service
@Transactional
public class FriendService {

  @Autowired
  private FriendDao friendDao;

  public int addFriend(){
   return 1;
  }

}
