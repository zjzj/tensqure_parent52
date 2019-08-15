package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Zj
 * @date 2019/8/10 16:43
 */
@Component
@RabbitListener(queues = "itheima")
public class getMsg2 {

  @RabbitHandler
  public void getSome(String msg){
    System.out.println("itheima：" + msg);
  }

}
