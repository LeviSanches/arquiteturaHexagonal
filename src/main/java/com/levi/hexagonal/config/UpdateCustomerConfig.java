package com.levi.hexagonal.config;

import com.levi.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.levi.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.levi.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.levi.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(
                findCustomerByIdUseCase,
                findAddressByZipCodeAdapter,
                updateCustomerAdapter
        );
    }
}
