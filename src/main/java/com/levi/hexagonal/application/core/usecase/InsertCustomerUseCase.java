package com.levi.hexagonal.application.core.usecase;

import com.levi.hexagonal.application.core.domain.Customer;
import com.levi.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.levi.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.levi.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.levi.hexagonal.application.ports.out.SendCpfForValidationOutput;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutput sendCpfForValidationOutput;

    public InsertCustomerUseCase(FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutput sendCpfForValidationOutput)
    {
        this.findAddresByZipCodeOutputPort = findAddresByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutput = sendCpfForValidationOutput;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddresByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutput.send(customer.getCpf());
    }
}
