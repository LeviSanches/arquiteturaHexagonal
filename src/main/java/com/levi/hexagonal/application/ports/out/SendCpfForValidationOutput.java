package com.levi.hexagonal.application.ports.out;

public interface SendCpfForValidationOutput {

    void send(String cpf);
}
