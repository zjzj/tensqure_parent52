package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

  /**
   * 推荐职位表
   * @param state state
   * @return list
   */
  public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

  /**
   * 最新职位表
   * @param state state
   * @return list
   */
  public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
	
}
