package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Zj
 * @date 2019/7/31 22:48
 */
public interface SpitDao extends MongoRepository<Spit,String> {

  /**
   * 根据上级id查询
   * @param parentid id
   * @param pageable pageable
   * @return page
   */
  public Page<Spit> findByParentid(String parentid, Pageable pageable);

}
