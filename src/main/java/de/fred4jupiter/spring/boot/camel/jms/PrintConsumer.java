package de.fred4jupiter.spring.boot.camel.jms;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.springframework.stereotype.Component;


@Component("printConsumer")
public class PrintConsumer {

    @Handler
    public void printMessage(@Body Object message) {
        System.out.println("msg=" + message);
    }
}
