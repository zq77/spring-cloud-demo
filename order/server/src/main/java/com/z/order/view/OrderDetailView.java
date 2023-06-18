package com.z.order.view;

import com.z.order.model.Order;
import com.z.order.model.OrderDetail;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class OrderDetailView {

    private Long Id;
    @NotBlank(message = "Product is not blank")
    private Long productId;
    @NotBlank(message = "Quantity is not blank")
    private Integer productQuantity;

    public OrderDetail toOrderDetail(Order order) {
        OrderDetail detail = new OrderDetail();
        detail.setOrder(order);
        detail.setCreateTime(new Date());
        return mergeOrderDetail(detail);
    }

    private OrderDetail mergeOrderDetail(OrderDetail detail) {
        detail.setProductId(this.getProductId());
        detail.setProductQuantity(this.getProductQuantity());
        return detail;
    }

    public static OrderDetailView toView(OrderDetail detail) {
        OrderDetailView view = new OrderDetailView();
        view.setId(detail.getId());
        view.setProductId(detail.getProductId());
        view.setProductQuantity(detail.getProductQuantity());
        return view;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
