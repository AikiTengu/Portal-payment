package com.mytona.Portalpayment.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Payment")
public class Payment implements Serializable {

    @Id
    private long paymentId;
    private LocalDate date;
    private short currencyType;
    private double sum;
    
}