package com.honor.simulator.order.persistence.repository;

import com.honor.simulator.order.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);

}
