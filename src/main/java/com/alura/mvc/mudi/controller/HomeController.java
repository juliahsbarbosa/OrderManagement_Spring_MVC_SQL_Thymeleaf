package com.alura.mvc.mudi.controller;

import com.alura.mvc.mudi.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/home")
    public String home(Model model) {

        Query query = entityManager.createQuery("select o from Order o", Order.class);

//        Order order = new Order();
//        order.setProductName("XIaomi Redmi Note 8");
//        order.setUrlImages("https://www.pointekonline.com/wp-content/uploads/2019/10/redmi-note-8-pro.jpg");
//        order.setUrlProduct("https://www.mi.com/in/redmi-note-8/");
//        order.setDescription("lorem ipsum");
//
        List<Order> orders = query.getResultList();
        model.addAttribute("orders", orders);

        return "home";
    }
}
