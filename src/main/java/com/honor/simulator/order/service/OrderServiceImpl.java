package com.honor.simulator.order.service;

import com.honor.simulator.order.api.dto.CustomerDto;
import com.honor.simulator.order.persistence.DataStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private DataStore dataStore;

    public OrderServiceImpl(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<CustomerDto> getCustomers() {

        return dataStore.getAllCustomers();
    }

    @Override
    public CustomerDto getCustomerById(String customerId) {
        CustomerDto customer = new CustomerDto();
        customer.setName("John");
        customer.setId(customerId);

        return customer;
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customer) {
        return dataStore.createCustomer(customer);
    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customer) {

        // Update customer

    }
}
