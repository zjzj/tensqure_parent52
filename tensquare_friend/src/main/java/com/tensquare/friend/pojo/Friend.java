package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author Zj
 * @date 2019/8/15 11:10
 */
@Entity
@Data
@IdClass(Friend.class)
public class Friend {

  @Id
  private String userid;

  @Id
  private String friendid;

  private String islike;

}
