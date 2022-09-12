package pl.coredev.front.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class RabbitSender
{
    private static final String QUEUE_NAME = "Q_FRONT_1";

    public void send() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("us2");
        factory.setPassword("pa2");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            LOG.info(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
