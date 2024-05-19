package manamaham.amirhossein.kafkatask.kafka;

import manamaham.amirhossein.kafkatask.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "AMTopicJson" , groupId = "myGroupId")
    public void consume(Employee employee){
        LOGGER.info(String.format("Jsone Message Received -> %s" , employee.toString()));
    }
}
