package com.tensquare.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zj
 * @date 2019/7/31 22:43
 */
@Data
public class Spit implements Serializable {

  @Id
  private String _id;
  private String content;
  private Date publishtime;
  private String userid;
  private String nickname;
  private Integer visits;
  private Integer thumbup;
  private Integer share;
  private Integer comment;
  private String state;
  private String parentid;

}
