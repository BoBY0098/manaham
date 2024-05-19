package manamaham.amirhossein.kafkatask.config;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.entity.Employee;
import manamaham.amirhossein.kafkatask.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
@RequiredArgsConstructor
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Employee employee){
        kafkaProducer.sendMessage(employee);
        ResponseEntity.BodyBuilder ok = ResponseEntity.ok();
        return ok.body("JSON Message Sent To THe Topic");
    }

}
