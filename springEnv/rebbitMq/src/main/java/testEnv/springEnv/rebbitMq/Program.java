package testEnv.springEnv.rebbitMq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Program {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
// "guest"/"guest" by default, limited to localhost connections
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setVirtualHost("virtual host");
        factory.setHost("host name");
        factory.setPort(2905);

        try {
            Connection conn = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
