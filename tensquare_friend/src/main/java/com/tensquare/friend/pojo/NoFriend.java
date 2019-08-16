package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Zj
 * @date 2019/8/15 11:11
 */
@Entity
@Data
@IdClass(NoFriend.class)
@Table(name = "tb_nofriend")
public class NoFriend implements Serializable {

  @Id
  private String userid;

  @Id
  private String friendid;

}
