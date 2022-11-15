package com.alura.mvc.mudi.controller;

import com.alura.mvc.mudi.model.Order;
import com.alura.mvc.mudi.model.OrderStatus;
import com.alura.mvc.mudi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public String home(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "home";
    }
    @GetMapping("/{status}")
    public String processing(@PathVariable("status") String status, Model model) {
        List<Order> orders = orderRepository.findByStatus(OrderStatus.valueOf(status.toUpperCase()));
        model.addAttribute("orders", orders);
        model.addAttribute("status", status);
        return "home";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }


}
