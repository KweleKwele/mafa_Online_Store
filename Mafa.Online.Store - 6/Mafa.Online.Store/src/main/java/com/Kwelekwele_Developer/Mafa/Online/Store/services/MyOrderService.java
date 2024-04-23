package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.models.MyOrders;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;

import java.util.List;
import java.util.Optional;

public interface MyOrderService {

    MyOrders addMyOrder (MyOrders newMyOrders);

    List<MyOrders> findAllMyOrders();

    MyOrders getMyOrdersByCustomerId(int customerId);

    MyOrders updateMyOrders(int id, MyOrders updatedMyOrders);

    Optional<MyOrders> deleteMyOrders(int id);

    Optional<MyOrders> getMyOrdersByMyOrdersId(int myOrdersId);

    List<Product> getMyOrdersProduct(int myOrdersId);
}
