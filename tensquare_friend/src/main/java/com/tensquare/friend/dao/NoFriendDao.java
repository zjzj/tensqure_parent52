package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Zj
 * @date 2019/8/15 11:16
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {

  /**
   * 联合主键查询
   * @param userid userid
   * @param friendid friendid
   * @return friend
   */
  public NoFriend findByUseridAndFriendid(String userid, String friendid);



}
