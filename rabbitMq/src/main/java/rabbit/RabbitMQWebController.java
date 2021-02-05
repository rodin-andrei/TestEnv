package rabbit;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {
   private final RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/producer")
    public String producer(@RequestBody Employee employee) {
        rabbitMQSender.send(employee);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}