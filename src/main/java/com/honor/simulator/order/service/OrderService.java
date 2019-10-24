package com.honor.simulator.order.service;

import com.honor.simulator.order.api.dto.CustomerDto;

import java.util.List;

public interface OrderService {
    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(String customerId);

    CustomerDto createNewCustomer(CustomerDto customer);

    void updateCustomer(String customerId, CustomerDto customer);
}
