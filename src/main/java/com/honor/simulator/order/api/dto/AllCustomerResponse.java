package com.honor.simulator.order.api.dto;

import java.util.List;

public class AllCustomerResponse {

    private List<CustomerDto> customers;

    public AllCustomerResponse(List<CustomerDto> customers) {
        this.customers = customers;
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }
}
