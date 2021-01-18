package com.mytona.Portalpayment.Controller;

import com.mytona.Portalpayment.Model.Entity.Payment;
import com.mytona.Portalpayment.Model.Repository.PaymentDAO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentDAO paymentDAO;

    @GetMapping("/{paymentId}")
    public Payment get(@PathVariable("paymentId") long paymentId) {
        return paymentDAO.findPayment(paymentId);
    }

    @GetMapping("/all")
    public List<Payment> getAll(){
        return paymentDAO.findAll();
    }

    @PostMapping
    public Payment save(@RequestBody Payment payment){
        return paymentDAO.save(payment);
    }

    @DeleteMapping("/{paymentId}")
    public String remove(@PathVariable("paymentId") long paymentId){
        return paymentDAO.deletePayment(paymentId);
    }
}