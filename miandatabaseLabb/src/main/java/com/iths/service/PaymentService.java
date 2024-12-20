package com.iths.service;

import com.iths.domain.pojo.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);

    List<Payment> getPaymentsByUserId(Long userId);

    List<Payment> getPaymentsByOrderId(Long orderId);

    Payment updatePaymentStatus(Long paymentId, Integer payStatus);
}
