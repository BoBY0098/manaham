package manamaham.amirhossein.kafkatask.controller;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    //http:localhost:8080/api/kafka/v1/publish?message=hello world(test)
    @GetMapping(value = "/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        ResponseEntity.BodyBuilder ok = ResponseEntity.ok();
        return ok.body("Message Sent To THe Topic");
    }
}
