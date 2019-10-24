package com.honor.simulator.order.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    @NotNull
    @Size(max = 10)
    private String name;

    private String id;

    public CustomerDto() {
    }

    public CustomerDto(@NotNull @Size(max = 10) String name) {
        this.name = name;
    }

    public CustomerDto(@NotNull @Size(max = 10) String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String customerId) {
        this.id = customerId;
    }

    public String getId() {
        return id;
    }
}
