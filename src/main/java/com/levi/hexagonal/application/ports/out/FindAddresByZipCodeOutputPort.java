package com.levi.hexagonal.application.ports.out;

import com.levi.hexagonal.application.core.domain.Address;

public interface FindAddresByZipCodeOutputPort {

    Address find(String zipCode);
}
