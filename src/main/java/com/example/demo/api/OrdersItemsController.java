package com.example.demo.api;

import com.example.demo.service.OrdersItemsService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.OrdersItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/ordersItems")
@RestController
public class OrdersItemsController {


    private final OrdersItemsService ordersItemsService;

    @Autowired
    public OrdersItemsController(OrdersItemsService ordersItemsService) { this.ordersItemsService = ordersItemsService; }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<OrdersItems> addOrdersItems(@RequestBody OrdersItems ordersItems) { return new ResponseEntity<>(ordersItemsService.addOrdersItems(ordersItems), HttpStatus.CREATED) ; }

    @GetMapping
    public List<OrdersItems> getAllOrdersItems() {
        return ordersItemsService.getAllOrdersItems();
    }

    @GetMapping(path = "{id}")
    public Optional getOrdersItemsById(@PathVariable("id") UUID id) { return ordersItemsService.getOrdersItemsById(id); }

    @DeleteMapping(path = "{id}")
    public void deleteOrdersItemsById(@PathVariable("id") UUID id) { ordersItemsService.deleteOrdersItems(id); }

    @PutMapping
    @CrossOrigin
    public ResponseEntity<OrdersItems> updateOrder(@PathVariable("id") UUID id, @RequestBody OrdersItems orderToUpdate) {
        ordersItemsService.updateOrdersItems(id, orderToUpdate);
        return new ResponseEntity<OrdersItems>(orderToUpdate, HttpStatus.OK);
    }
}
