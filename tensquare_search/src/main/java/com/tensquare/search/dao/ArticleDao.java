package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Zj
 * @date 2019/8/9 11:00
 */
public interface ArticleDao extends ElasticsearchRepository<Article,String> {

  public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);

}
