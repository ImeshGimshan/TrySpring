package org.cyklon.tryoutspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.cyklon.tryoutspringboot.DTO.OrderRequestDTO;
import org.cyklon.tryoutspringboot.Model.Order;
import org.cyklon.tryoutspringboot.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO req) {
        return new ResponseEntity<>(orderService.createOrder(req), HttpStatus.CREATED);
    }
}
