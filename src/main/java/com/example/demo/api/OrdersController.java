package com.example.demo.api;

import com.example.demo.service.OrdersService;
import java.util.List;
import java.util.UUID;
import com.example.demo.model.Orders;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/orders")
@RestController
public class OrdersController {


    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {
        ordersService.addOrder(orders);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping(path = "{id}")
    public Orders getOrdersById(@PathVariable("id") UUID id) {
        return ordersService.getOrdersById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<UUID> deleteOrderById(@PathVariable("id") UUID id) {
        ordersService.deleteOrder(id);
        return new ResponseEntity(id, HttpStatus.NO_CONTENT);
    }

//    @PutMapping(path = "{id}")
//    public void updateOrder(@PathVariable("id") UUID id, @RequestBody Orders orderToUpdate) {
//        OrdersService.updateOrder(id, orderToUpdate);
//    }
}
