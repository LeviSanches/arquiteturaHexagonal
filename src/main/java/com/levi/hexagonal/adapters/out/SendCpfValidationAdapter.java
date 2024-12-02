package com.levi.hexagonal.adapters.out;

import com.levi.hexagonal.application.ports.out.SendCpfForValidationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutput {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
            kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
