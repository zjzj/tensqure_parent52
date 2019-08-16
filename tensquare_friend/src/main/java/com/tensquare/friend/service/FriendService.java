package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
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

  @Autowired
  private NoFriendDao noFriendDao;

  public int addFriend(String userid,String friendid){
    //先判断userid到friendid是否有数据，有就是重复添加好友，返回0
    Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
    if(friend != null){
      return 0;
    }
    //直接添加好友，让数据库中添加userid到friendid，并且type为0
    friend =new Friend();
    friend.setUserid(userid);
    friend.setFriendid(friendid);
    friend.setIslike("0");
    friendDao.save(friend);
    //判断friendid到userid方向是否存在，存在则将两个人的type都更改为1
    if(friendDao.findByUseridAndFriendid(friendid,userid) != null){
      friendDao.updateIslike("1",userid,friendid);
      friendDao.updateIslike("1",friendid,userid);
    }
    return 1;
  }

  public int addNoFriend(String userid, String friendid) {
    //先判断是否是非好友
    NoFriend noFriend =noFriendDao.findByUseridAndFriendid(userid, friendid);
    if(noFriend != null){
      return 0;
    }
    noFriend = new NoFriend();
    noFriend.setUserid(userid);
    noFriend.setFriendid(friendid);
    noFriendDao.save(noFriend);
    return 1;
  }

  public void deleteFriend(String userid, String friendid) {
    //删除好友
    friendDao.deleteFriend(userid, friendid);
    //更改对方
    friendDao.updateIslike("0",friendid,userid);
    //添加非好友
    NoFriend noFriend = new NoFriend();
    noFriend.setUserid(userid);
    noFriend.setFriendid(friendid);
    noFriendDao.save(noFriend);
  }
}
