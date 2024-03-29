package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Zj
 * @date 2019/7/21 15:48
 */
@Data
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

  @Id
  private String id;

  /**
   * //标签名称
   */
  private String labelname;

  /**
   * //状态
   */
  private String state;

  /**
   * //使用数量
   */
  private Long count;

  /**
   * //关注数
   */
  private Long fans;

  /**
   * //是否推荐
   */
  private String recommend;

}
