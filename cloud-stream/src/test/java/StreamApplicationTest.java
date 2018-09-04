import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guodahai
 * @version 2018/9/4 16:30
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = {StreamApplicationTest.SinkSender.class})
public class StreamApplicationTest {

    @Resource
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTester() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }

    public interface SinkSender {
        String OUTPUT = "input";
        @Output(SinkSender.OUTPUT)
        MessageChannel output();
    }
}
