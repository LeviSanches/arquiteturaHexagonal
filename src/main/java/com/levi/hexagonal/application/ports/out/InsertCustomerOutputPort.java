package com.levi.hexagonal.application.ports.out;

import com.levi.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
