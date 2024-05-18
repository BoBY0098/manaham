package manamaham.amirhossein.kafkatask.controller;

import lombok.RequiredArgsConstructor;
import manamaham.amirhossein.kafkatask.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;


}
