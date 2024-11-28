package com.levi.hexagonal.application.ports.in;

import com.levi.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
