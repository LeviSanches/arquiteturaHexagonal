package com.levi.hexagonal.adapters.out;

import com.levi.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.levi.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.levi.hexagonal.application.core.domain.Address;
import com.levi.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddresByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
