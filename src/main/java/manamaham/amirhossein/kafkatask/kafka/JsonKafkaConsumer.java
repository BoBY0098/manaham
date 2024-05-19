package manamaham.amirhossein.kafkatask.kafka;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.entity.EmployeeReq;
import manamaham.amirhossein.kafkatask.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonKafkaConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    private final EmployeeService service;

    @KafkaListener(topics = "AMTopicJson" , groupId = "myGroupId")
    public void consume(EmployeeReq req){
        LOGGER.info(String.format("Jsone Message Received -> %s" , req.toString()));
        service.saveEmployee(req);
        LOGGER.info("Employee Object Created");
    }
}
