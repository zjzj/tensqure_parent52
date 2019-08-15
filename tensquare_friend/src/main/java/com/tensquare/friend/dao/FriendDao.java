package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zj
 * @date 2019/8/15 11:16
 */
public interface FriendDao extends JpaRepository<Friend,String> {

  /**
   * 联合主键查询
   * @param userid userid
   * @param friendid friendid
   * @return friend
   */
  public Friend findByUseridAndFriendid(String userid,String friendid);

}
