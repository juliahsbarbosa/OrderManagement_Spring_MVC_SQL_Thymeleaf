package com.alura.mvc.mudi.controller;

import com.alura.mvc.mudi.dto.NewOrder;
import com.alura.mvc.mudi.model.Order;
import com.alura.mvc.mudi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("form")
    public String form(NewOrder newOrder){
        return "order/form";
    }

    @PostMapping("new")
    public String newOrder(@Valid NewOrder newOrder, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "order/form";
        }

        Order order = newOrder.toOrder();
        orderRepository.save(order);
        return "redirect:/home";
    }





}
