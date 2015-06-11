package de.fred4jupiter.spring.boot.camel.jms;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootCamelJmsApplication.class)
public class SpringBootCamelJmsApplicationTests {

    @EndpointInject(uri = "mock:printConsumer")
    private MockEndpoint mockEndpoint;

    @Test
    public void shouldProduceMessages() throws InterruptedException {
        mockEndpoint.setExpectedCount(1);
        mockEndpoint.expectedBodiesReceived("Hello World");
        mockEndpoint.assertIsSatisfied();
    }

}
