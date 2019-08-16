package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Zj
 * @date 2019/8/15 11:10
 */
@Entity
@Data
@IdClass(Friend.class)
@Table(name = "tb_friend")
public class Friend implements Serializable {

  @Id
  private String userid;

  @Id
  private String friendid;

  private String islike;

}
