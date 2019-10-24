package com.honor.simulator.order.api.controller;

import com.honor.simulator.order.api.dto.AllCustomerResponse;
import com.honor.simulator.order.api.dto.CustomerDto;
import com.honor.simulator.order.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OrderControllerTest {
    @Mock
    OrderService orderService;
    @InjectMocks
    OrderController orderController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOrder() throws Exception {
        when(orderService.getCustomers()).thenReturn(Arrays.<CustomerDto>asList(new CustomerDto("name", "id")));

        ResponseEntity<AllCustomerResponse> result = orderController.getOrder();
        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }


}

