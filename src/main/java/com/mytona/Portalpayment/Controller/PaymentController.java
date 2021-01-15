package com.mytona.Portalpayment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO: CRUD payments


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable("orderId") String orderId) {
        return "Successfully proceeded a payment for order:" + " " + orderId;
    }
}
