package com.example.demo.api;

import com.example.demo.service.OrdersItemsService;
import java.util.List;
import java.util.UUID;
import com.example.demo.model.OrdersItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/ordersItems")
@RestController
public class OrdersItemsController {


    private final OrdersItemsService ordersItemsService;

    @Autowired
    public OrdersItemsController(OrdersItemsService ordersItemsService) {
        this.ordersItemsService = ordersItemsService;
    }

    @PostMapping
    public void addOrdersItems(@RequestBody OrdersItems ordersItems) {
        ordersItemsService.addOrdersItems(ordersItems);
    }

    @GetMapping
    public List<OrdersItems> getAllOrdersItems() {
        return ordersItemsService.getAllOrdersItems();
    }

    @GetMapping(path = "{id}")
    public OrdersItems getOrdersItemsById(@PathVariable("id") UUID id) {
        return ordersItemsService.getOrdersItemsById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrdersItemsById(@PathVariable("id") UUID id) {
        ordersItemsService.deleteOrdersItems(id);
    }
}
