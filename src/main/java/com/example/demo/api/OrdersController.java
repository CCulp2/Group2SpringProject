package com.example.demo.api;

import com.example.demo.model.OrderCustomerMapper;
import com.example.demo.service.OrdersService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/orders")
@RestController
@CrossOrigin("*")
public class OrdersController {


    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Orders> addOrder(@RequestBody OrderCustomerMapper incomingOrder) {
        Orders order = new Orders();
        order.setCustomerID(incomingOrder.getCustomerID());
        order.setProducts(incomingOrder.getProductsToAdd());
        order.setOrderDate(LocalDate.now().toString());
        return new ResponseEntity<>(ordersService.addOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Orders> getAllOrders() { return ordersService.getAllOrders(); }

    @GetMapping(path = "{id}")
    public Optional<Orders> getOrderById(@PathVariable("id") Long id) { return ordersService.getOrderById(id); }

    @DeleteMapping(path = "{id}")
    public void deleteOrderById(@PathVariable("id") Long id) { ordersService.deleteOrder(id); }

    @PutMapping(path = "{id}")
    @CrossOrigin
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") Long id, @RequestBody Orders orderToUpdate) {
        ordersService.updateOrder(id, orderToUpdate);
        return new ResponseEntity<Orders>(orderToUpdate, HttpStatus.OK);
    }


}
