package com.adex.demo.jpa.impl;

import com.adex.demo.domain.api.CustomerRepository;
import com.adex.demo.domain.exceptions.CustomerNotFoundException;
import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.jpa.impl.entities.CustomerEntity;
import com.adex.demo.jpa.impl.repositories.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerEntityRepository entityRepository;

    @Override
    public Integer getCustomerStatus(DomainCustomerRequest customerRequest) {
        final CustomerEntity entity = entityRepository
                .findById(customerRequest.customerID())
                .orElseThrow(()->
                        new CustomerNotFoundException("Customer with ID " + customerRequest.customerID() + " not found"));
        return entity.getActive();
    }

    @Override
    public void saveCustomerRequest(DomainCustomerRequest customerRequest) {
        //TODO: replace with org.mapstruct
        //TODO: and implement something
    }
}
