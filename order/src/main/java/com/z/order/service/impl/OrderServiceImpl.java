package com.z.order.service.impl;

import com.z.order.model.Order;
import com.z.order.model.OrderDetail;
import com.z.order.repository.OrderDetailRepo;
import com.z.order.repository.OrderRepo;
import com.z.order.service.OrderService;
import com.z.order.view.OrderView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepo orderRepo;

    @Resource
    private OrderDetailRepo orderDetailRepo;

    @Override
    @Transactional
    public OrderView create(OrderView view) {
        Order order = view.toOrder();
        // TODO calculate fee, need request product server
        order.setAmount(3.0);
        order = orderRepo.save(order);
        Order finalOrder = order;
        view.getItems().forEach(item -> {
            OrderDetail detail = item.toOrderDetail(finalOrder);
            // TODO temp
            detail.setProductName("test");
            detail.setProductPrice(new BigDecimal("1.0"));
            orderDetailRepo.save(detail);
        });
        return OrderView.toView(order);
    }
}
