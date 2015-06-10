package de.fred4jupiter.spring.boot.camel.jms;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleProducer {

    @Autowired
    private ProducerTemplate template;

    @Scheduled(cron = "*/5 * * * * *")
    public void createMessages() {
        System.out.println("sending message...");
        template.sendBody("activemq:invoices","Hello World");
    }

}
