package manamaham.amirhossein.kafkatask.config;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.entity.EmployeeReq;
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
    public ResponseEntity<String> publish(@RequestBody EmployeeReq req){
        kafkaProducer.sendMessage(req);
        ResponseEntity.BodyBuilder ok = ResponseEntity.ok();
        return ok.body("JSON Req Model Sent To The Topic Successfully");
    }

}
