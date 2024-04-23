package com.Kwelekwele_Developer.Mafa.Online.Store.services;

import com.Kwelekwele_Developer.Mafa.Online.Store.exception.InvalidCustomerId;
import com.Kwelekwele_Developer.Mafa.Online.Store.exception.MyOrderNotFound;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.MyOrders;
import com.Kwelekwele_Developer.Mafa.Online.Store.models.Product;
import com.Kwelekwele_Developer.Mafa.Online.Store.repository.MyOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MyOrderServiceImpl implements MyOrderService {

    @Autowired
    private MyOrderDao myOrderDao;

    @Autowired
    public MyOrderServiceImpl(MyOrderDao myOrderDao) {

        this.myOrderDao = myOrderDao;
    }

    @Override
    public MyOrders addMyOrder(MyOrders newMyOrders) {
        return myOrderDao.save(newMyOrders);
    }

    @Override
    public List<MyOrders> findAllMyOrders() {
        return myOrderDao.findAll();
    }

    @Override
    public MyOrders getMyOrdersByCustomerId(int customerId) {

        List<MyOrders> myOrdersList = myOrderDao.findAll();

        MyOrders tempMyOrders = null;
        for (int i = 0; i < myOrdersList.size(); i++) {
            if (myOrdersList.get(i).getCustomer().getId() == customerId) {

                tempMyOrders = myOrdersList.get(i);

            } else if (myOrdersList.get(i).getCustomer().getId() != customerId) {

                throw new InvalidCustomerId("Invalid Customer Id.......");

            }
        }
        return tempMyOrders;

    }

    @Override
    public MyOrders updateMyOrders(int id, MyOrders updatedMyOrders) {

        Optional<MyOrders> myOrders = myOrderDao.findById(id);

        MyOrders myOrders1 = null;
        if (myOrders.isPresent()) {

            myOrders1 = myOrders.get();

            myOrders1.setOrderStatus(updatedMyOrders.getOrderStatus());
            myOrders1.setAddress(updatedMyOrders.getAddress());
            myOrders1.setCustomer(updatedMyOrders.getCustomer());
            myOrders1.setLocalDateTime(updatedMyOrders.getLocalDateTime());
            myOrders1.setProductList(updatedMyOrders.getProductList());

            myOrderDao.save(myOrders1);

        } else {

            throw new MyOrderNotFound("Order with That Id not found");

        }


        return myOrders1;
    }

    @Override
    public Optional<MyOrders> deleteMyOrders(int id) {

        Optional<MyOrders> myOrders = myOrderDao.findById(id);

        if (myOrders.isPresent()) {

            myOrderDao.deleteById(myOrders.get().getId());
            return myOrders;

        } else {

            throw new MyOrderNotFound("Order with That Id not found");

        }

    }

    @Override
    public Optional<MyOrders> getMyOrdersByMyOrdersId(int myOrdersId) {

        Optional<MyOrders> myOrders = myOrderDao.findById(myOrdersId);

        if (myOrders.isPresent()) {

            return myOrders;

        } else {

            throw new MyOrderNotFound("Order with That Id not found");
        }

    }

    @Override
    public List<Product> getMyOrdersProduct(int myOrdersId) {

        Optional<MyOrders> myOrders = myOrderDao.findById(myOrdersId);

        if (myOrders.isPresent()) {

            return myOrders.get().getProductList();

        } else {
            throw new MyOrderNotFound("Order with That Id not found");
        }

    }
}
