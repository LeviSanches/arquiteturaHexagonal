package com.levi.hexagonal.application.core.usecase;

import com.levi.hexagonal.application.core.domain.Customer;
import com.levi.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.levi.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.levi.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort)
    {
        this.findAddresByZipCodeOutputPort = findAddresByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;

    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddresByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
