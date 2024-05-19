package manamaham.amirhossein.kafkatask.kafka;

import manamaham.amirhossein.kafkatask.entity.Employee;
import manamaham.amirhossein.kafkatask.entity.EmployeeReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String , Employee> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(EmployeeReq req){

        LOGGER.info(String.format("Message Sent => %s" , req.toString()));

        Message<EmployeeReq> message = MessageBuilder
                .withPayload(req)
                .setHeader(KafkaHeaders.TOPIC , "AMTopicJson")
                .build();

        kafkaTemplate.send(message);
    }
}
