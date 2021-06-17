package com.z.order.repository;


import com.z.order.OrderApplicationTests;
import com.z.order.model.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import javax.annotation.Resource;
import java.math.BigDecimal;

public class OrderDetailRepoTest extends OrderApplicationTests {

    @Resource
    private OrderDetailRepo orderDetailRepo;

    @Test
    public void testSave() {
        OrderDetail detail = new OrderDetail();
        detail.setOrderId(1L);
        detail.setProductId(1L);
        detail.setProductIcon("icon");
        detail.setProductName("product");
        detail.setProductPrice(new BigDecimal("10.0"));
        detail.setProductQuantity(10);
        OrderDetail result = orderDetailRepo.save(detail);
        AssertionErrors.assertTrue("", result != null);
    }
}