package com.ocean.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author guodahai
 * @version 2018/9/4 15:52
 */
@EnableBinding(Sink.class)
public class StreamReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }

}
