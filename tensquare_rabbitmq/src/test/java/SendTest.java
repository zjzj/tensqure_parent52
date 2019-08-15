import com.rabbitmq.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Zj
 * @date 2019/8/10 16:39
 */
@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class SendTest {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void sendMsg1(){
    rabbitTemplate.convertAndSend("itcast","33直接模式测试1");
  }

  @Test
  public void sendMsg2(){
    rabbitTemplate.convertAndSend("chuanzhi","","分裂模式测试");
  }

  @Test
  public void sendMsg3(){
    rabbitTemplate.convertAndSend("topic84","good.log","主题模式测试");
  }

  @Test
  public void test(){
    String as = (String) redisTemplate.opsForValue().get("checkcode_123456789");
    System.out.println(as);
  }

}
