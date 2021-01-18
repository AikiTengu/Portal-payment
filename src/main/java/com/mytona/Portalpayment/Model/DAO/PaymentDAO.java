package com.mytona.Portalpayment.Model.DAO;


import com.mytona.Portalpayment.Model.Entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDAO {

    public static  final String HASH_KEY = "Payment";

    @Autowired
    private RedisTemplate redisTemplate;


    public Payment save(Payment payment){
        redisTemplate.opsForHash().put(HASH_KEY, payment.getPaymentId(),payment);
        return payment;
    }

    public List<Payment> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Payment findPayment(long paymentId){
        return (Payment) redisTemplate.opsForHash().get(HASH_KEY,paymentId);
    }

    public String deletePayment(long paymentId){
        redisTemplate.opsForHash().delete(HASH_KEY, paymentId);
        return "Deleted payment";
    }
}
