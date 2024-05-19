package manamaham.amirhossein.kafkatask.kafka;

import manamaham.amirhossein.kafkatask.entity.Employee;
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

    public void sendMessage(Employee employee){

        LOGGER.info(String.format("Message Sent => %s" , employee.toString()));

        Message<Employee> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC , "AMTopicJson")
                .build();

        kafkaTemplate.send(message);
    }
}
