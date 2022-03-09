package com.example.demo.api;

import com.example.demo.service.OrdersService;
import java.util.List;
import java.util.UUID;
import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/orders")
@RestController
public class OrdersController {


    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public void addOrder(@RequestBody Orders orders) {
        ordersService.addOrder(orders);
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
    public void deleteOrderById(@PathVariable("id") UUID id) {
        ordersService.deleteOrder(id);
    }

//    @PutMapping(path = "{id}")
//    public void updateOrder(@PathVariable("id") UUID id, @RequestBody Orders orderToUpdate) {
//        OrdersService.updateOrder(id, orderToUpdate);
//    }
}
