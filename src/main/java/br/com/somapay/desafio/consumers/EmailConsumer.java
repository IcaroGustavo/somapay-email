package br.com.somapay.desafio.consumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import br.com.somapay.desafio.config.RabbitMQConfig;


@Component
public class EmailConsumer {

    // @Autowired
    // EmailService emailService;

    // @RabbitListener(queues = "somapay.email")
    // public void listen(@Payload EmailDto emailDto) {
    //     br.com.somapay.desafio.model.Email emailModel = new br.com.somapay.desafio.model.Email();
    //     BeanUtils.copyProperties(emailDto, emailModel);
    //     emailService.sendEmail(emailModel);
    //     System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    // }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumer(Message message) {
        simpMessagingTemplate.convertAndSend(EmailWebSocketConfiguration.BROKER,
                new String(message.getBody()));
    }
}