package com.z.order.controller;

import com.z.order.exception.OrderException;
import com.z.order.service.OrderService;
import com.z.order.util.ResponseUtil;
import com.z.order.view.OrderView;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/api/orders")
    public ResponseEntity create(@RequestBody @Valid OrderView orderView, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseUtil.validationError(bindingResult.getFieldErrors());
        }
        OrderView result = orderService.create(orderView);
        return ResponseUtil.success(result);
    }

    @PutMapping("/api/orders/finish")
    public ResponseEntity finish(Long orderId) {
        System.out.println(orderId);
        try {
            OrderView result = orderService.finish(orderId);
            return ResponseUtil.success(result);
        } catch (OrderException e) {
            return ResponseUtil.badRequestError(e.getMessage());
        }
    }
}
