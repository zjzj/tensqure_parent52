package entity;

import lombok.Data;

import java.util.List;

/**
 * @author Zj
 * @date 2019/7/21 14:10
 */
@Data
public class PageResult <T>{

  private long total;

  private List<T> rows;

  public PageResult() {
  }

  public PageResult(long total, List<T> rows) {
    this.total = total;
    this.rows = rows;
  }
}
