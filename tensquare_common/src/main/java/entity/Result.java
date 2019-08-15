package entity;

import lombok.Data;

/**
 * @author Zj
 * @date 2019/7/21 14:00
 */
@Data
public class Result {

  public Result(boolean flag, Integer code, String message, Object data) {
    super();
    this.flag = flag;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public Result() {
  }

  public Result(boolean flag, Integer code, String message) {
    super();
    this.flag = flag;
    this.code = code;
    this.message = message;
  }

  /**
   * 是否成功
   */
  private boolean flag;

  /**
   * 状态码
   */
  private Integer code;

  /**
   * 返回信息
   */
  private String message;

  /**
   * 返回数据
   */
  private Object data;

}
