package com.z.order.view;

import com.z.order.enums.OrderStatus;
import com.z.order.enums.PayStatus;
import com.z.order.model.Order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class OrderView {
    private Long id;
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private List<OrderDetailView> items;

    public Order toOrder() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.NEW);
        order.setPayStatus(PayStatus.WAIT);
        order.setCreateTime(new Date());
        return mergeOrder(order);
    }

    public Order mergeOrder(Order order) {
        order.setBuyerName(this.getName());
        order.setBuyerAddress(this.getAddress());
        order.setBuyerOpenid(this.getOpenid());
        order.setBuyerPhone(this.getPhone());
        return order;
    }

    public static OrderView toView(Order order) {
        OrderView view = new OrderView();
        view.setId(order.getId());
        view.setAddress(order.getBuyerAddress());
        view.setOpenid(order.getBuyerOpenid());
        view.setName(order.getBuyerName());
        view.setPhone(order.getBuyerPhone());

        return view;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public List<OrderDetailView> getItems() {
        return items;
    }

    public void setItems(List<OrderDetailView> items) {
        this.items = items;
    }

}
