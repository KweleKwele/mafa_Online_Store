package com.Kwelekwele_Developer.Mafa.Online.Store.controller;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.MyOrders;
import com.Kwelekwele_Developer.Mafa.Online.Store.services.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/myOrder")
public class MyOrderController {
    @Autowired
    private MyOrderService myOrderService;

    @Autowired
    public MyOrderController(MyOrderService myOrderService) {

        this.myOrderService = myOrderService;
    }

    @PostMapping("/create")
    public MyOrders addOrder(@RequestBody MyOrders order) {

        return myOrderService.addMyOrder(order);

    }

    @RequestMapping("/list_my_Orders")
    public List<MyOrders> findAll() {

        return myOrderService.findAllMyOrders();
    }

    @RequestMapping("/customer/order/{customer_id}")
    public Optional<MyOrders> getMyOrdersByCustomerId(@PathVariable Integer customer_id) {

        return Optional.ofNullable(myOrderService.getMyOrdersByCustomerId(customer_id));

    }

    @RequestMapping("/order/{my_Order_id}")
    public Optional<MyOrders> getMyOrdersByMyOrdersId(@PathVariable Integer my_Order_id) {

        return myOrderService.getMyOrdersByMyOrdersId(my_Order_id);

    }


}
