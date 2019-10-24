package com.honor.simulator.order.persistence;

import com.honor.simulator.order.api.dto.CustomerDto;
import com.honor.simulator.order.persistence.entity.Customer;
import com.honor.simulator.order.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataStore {

    private CustomerRepository repository;

    public DataStore(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        return getCustomerDto(repository.save(getCustomer(customerDto)));
    }

    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> result = new ArrayList<>();
        repository.findAll().forEach(customer -> result.add(getCustomerDto(customer)));
        return result;
    }

    private CustomerDto getCustomerDto(Customer customer) {
        return new CustomerDto(customer.getName(), customer.getId().toString());
    }

    private Customer getCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getName());
    }
}
