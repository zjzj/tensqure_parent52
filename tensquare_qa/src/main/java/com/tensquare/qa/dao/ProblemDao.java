package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

  /**
   * 最新回复列表
   * @param labelid 标签id
   * @param pageable 分页信息
   * @return list
   */
  @Query(value = "SELECT * FROM tb_problem JOIN tb_pl ON id=problemid AND labelid=? ORDER BY replytime DESC",nativeQuery = true)
  public Page<Problem> newList(String labelid, Pageable pageable);

  /**
   * 最热回复列表
   * @param labelid 标签id
   * @param pageable 分页信息
   * @return list
   */
  @Query(value = "SELECT * FROM tb_problem JOIN tb_pl ON id=problemid AND labelid=? ORDER BY reply DESC",nativeQuery = true)
  public Page<Problem> hotList(String labelid, Pageable pageable);

  /**
   * 等待回复列表
   * @param labelid 标签id
   * @param pageable 分页信息
   * @return list
   */
  @Query(value = "SELECT * FROM tb_problem JOIN tb_pl ON id=problemid AND labelid=? AND reply=0 ORDER by createtime DESC",nativeQuery = true)
  public Page<Problem> waitList(String labelid, Pageable pageable);
	
}
