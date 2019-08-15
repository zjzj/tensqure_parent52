package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zj
 * @date 2019/7/21 16:04
 */
@Service
@Transactional
public class LabelService {

  @Autowired
  private LabelDao labelDao;

  @Autowired
  IdWorker idWorker;

  public List<Label> findAll(){
    return labelDao.findAll();
  }

  public Label findById(String id){
    return labelDao.findById(id).get();
  }

  public void save(Label label){
    label.setId(idWorker.nextId()+"");
    labelDao.save(label);
  }

  public void update(Label label){
    labelDao.save(label);
  }

  public void deleteById(String id){
    labelDao.deleteById(id);
  }


  public List<Label> findSearch(Label label) {
    return labelDao.findAll(new Specification<Label>() {

      /**
       * @param root 根对象，要把条件封装到那个对象中
       * @param query 封装的都是查询的关键字，比如 order by group by等
       * @param cb 用来封装条件对象的，如果直接返回null，则表示不需要任何条件
       * @return 查询的东西
       */
      @Override
      public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        if(label.getLabelname() != null && !"".equals(label.getLabelname())){
          Predicate predicate = cb.like(root.get("labelname").as(String.class),"%" + label.getLabelname() + "%");
          list.add(predicate);
        }
        if(label.getState() != null && !"".equals(label.getState())){
          Predicate predicate = cb.equal(root.get("state").as(String.class),label.getState());
          list.add(predicate);
        }
        Predicate[] predicates = new Predicate[list.size()];
        list.toArray(predicates);
        return cb.and(predicates);
      }
    });
  }

  public Page<Label> pageQuery(Label label, int page, int size) {
    Pageable pageable = PageRequest.of(page-1,size);
    return labelDao.findAll(new Specification<Label>() {

      /**
       * @param root 根对象，要把条件封装到那个对象中
       * @param query 封装的都是查询的关键字，比如 order by group by等
       * @param cb 用来封装条件对象的，如果直接返回null，则表示不需要任何条件
       * @return 查询的东西
       */
      @Override
      public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        if(label.getLabelname() != null && !"".equals(label.getLabelname())){
          Predicate predicate = cb.like(root.get("labelname").as(String.class),"%" + label.getLabelname() + "%");
          list.add(predicate);
        }
        if(label.getState() != null && !"".equals(label.getState())){
          Predicate predicate = cb.equal(root.get("state").as(String.class),label.getState());
          list.add(predicate);
        }
        Predicate[] predicates = new Predicate[list.size()];
        list.toArray(predicates);
        return cb.and(predicates);
      }
    },pageable);
  }
}
