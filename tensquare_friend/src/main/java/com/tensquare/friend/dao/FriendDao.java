package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

  @Modifying
  @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?",nativeQuery = true)
  public void updateIslike(String type,String userid,String friendid);

  @Modifying
  @Query(value = "delete from tb_friend  WHERE userid=? AND friendid=?",nativeQuery = true)
  public void deleteFriend(String userid,String friendid);
}
