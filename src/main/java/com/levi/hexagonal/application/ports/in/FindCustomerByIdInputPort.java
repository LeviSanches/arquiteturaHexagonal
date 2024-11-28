package com.levi.hexagonal.application.ports.in;

import com.levi.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
