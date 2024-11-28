package com.levi.hexagonal.application.core.usecase;

import com.levi.hexagonal.application.core.domain.Customer;
import com.levi.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.levi.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.levi.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort
            ,FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddresByZipCodeOutputPort = findAddresByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddresByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
    }
}
