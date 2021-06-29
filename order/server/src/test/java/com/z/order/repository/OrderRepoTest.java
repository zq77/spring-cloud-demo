package com.z.order.repository;

import com.z.order.OrderApplicationTests;
import com.z.order.enums.OrderStatus;
import com.z.order.enums.PayStatus;
import com.z.order.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@Component
public class OrderRepoTest extends OrderApplicationTests {

    @Resource
    private OrderRepo orderRepo;

    @Test
    public void testSave() {
        Order order = new Order();
        order.setBuyerName("test");
        order.setBuyerOpenid("testOpenid");
        order.setBuyerPhone("18909382293");
        order.setBuyerAddress("address");
        order.setAmount(10.0);
        order.setOrderStatus(OrderStatus.NEW);
        order.setPayStatus(PayStatus.WAIT);
        Order result = orderRepo.save(order);
        assertTrue("", result != null);
    }
}