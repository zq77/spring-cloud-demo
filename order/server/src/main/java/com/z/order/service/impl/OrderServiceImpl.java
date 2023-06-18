package com.z.order.service.impl;

import com.z.order.enums.OrderStatus;
import com.z.order.exception.OrderException;
import com.z.order.model.Order;
import com.z.order.model.OrderDetail;
import com.z.order.repository.OrderDetailRepo;
import com.z.order.repository.OrderRepo;
import com.z.order.service.OrderService;
import com.z.order.view.OrderDetailView;
import com.z.order.view.OrderView;
import com.z.product.client.ProductApi;
import com.z.product.common.ProductView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepo orderRepo;

    @Resource
    private OrderDetailRepo orderDetailRepo;

    @Resource
    private ProductApi productApi;

    @Override
    @Transactional
    public OrderView create(OrderView view) {
        Order order = view.toOrder();
        order.setAmount(0.0);
        order = orderRepo.save(order);

        List<Long> prdIds = view.getItems().stream().map(OrderDetailView::getProductId).collect(Collectors.toList());
        Map<Long, ProductView> prodMap = productApi.getProductByIds(prdIds).stream().collect(Collectors.toMap(ProductView::getId, Function.identity(), (n1, n2) -> n1));

        AtomicReference<Double> totalAmount = new AtomicReference<>(0.0);
        Order finalOrder = order;
        view.getItems().forEach(item -> {
            OrderDetail detail = item.toOrderDetail(finalOrder);
            ProductView prod = prodMap.get(item.getProductId());
            if (prod != null) {
                detail.setProductName(prod.getName());
                detail.setProductIcon(prod.getIcon());
                detail.setProductPrice(prod.getPrice());
                orderDetailRepo.save(detail);
                totalAmount.updateAndGet(v -> v + detail.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())).doubleValue());
            }
        });
        order.setAmount(totalAmount.get());

        productApi.buy(view.getItems().stream().map(i -> new ProductView(i.getProductId(), i.getProductQuantity())).collect(Collectors.toList()));
        return OrderView.toView(order);
    }

    @Override
    @Transactional
    public OrderView finish(Long orderId) {
        Optional<Order> orderOptional = orderRepo.findById(orderId);
        if (!orderOptional.isPresent()) {
            throw new OrderException(OrderException.NOT_FOUND);
        }

        if (orderOptional.get().getOrderStatus() != OrderStatus.NEW) {
            throw new OrderException(OrderException.ORDER_STATUS_ERROR);
        }
        orderOptional.get().setOrderStatus(OrderStatus.COMPLETED);
        orderRepo.save(orderOptional.get());
        List<OrderDetail> details = orderDetailRepo.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(details)) {
            throw new OrderException(OrderException.ORDER_DETAIL_EMPTY);
        }
        OrderView orderView = OrderView.toView(orderOptional.get());
        orderView.setItems(details.stream().map(OrderDetailView::toView).collect(Collectors.toList()));
        return orderView;
    }
}
