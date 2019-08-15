package com.tensquare.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author Zj
 * @date 2019/8/9 10:38
 */
@Data
@Document(indexName = "tensquare_article",type = "article")
public class Article implements Serializable {

  @Id
  private String id;

  /**
   * 是否索引:该域能否被搜索
   * 是否分词:搜索的时候是整体搜索，还是全部搜索
   * 是否存储:是否在页面显示
   */
  @Field(index = true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
  private String title;

  @Field(index = true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
  private String content;

  /**
   * 审核状态
   */
  private String state;

}
