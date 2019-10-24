package com.honor.simulator.order.api.controller;

import com.honor.simulator.order.api.dto.AllCustomerResponse;
import com.honor.simulator.order.api.dto.CustomerDto;
import com.honor.simulator.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("customers")
    public ResponseEntity<AllCustomerResponse> getOrder() {

        return new ResponseEntity<>(new AllCustomerResponse(orderService.getCustomers()),
                HttpStatus.OK);
    }

    @GetMapping("customers/{customerId}")
     public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId) {
        return new ResponseEntity<>(orderService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping("customers")
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody @Validated CustomerDto customer) {

        return new ResponseEntity(orderService.createNewCustomer(customer), HttpStatus.CREATED);

    }

    @PutMapping("customers/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable String customerId, @RequestBody CustomerDto customer) {
        orderService.updateCustomer(customerId, customer);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
