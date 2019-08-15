package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Zj
 * @date 2019/8/15 11:11
 */
@Entity
@Data
@IdClass(NoFriend.class)
public class NoFriend {

  @Id
  private String userid;

  @Id
  private String friendid;

}
