package com.iths.service.impl;

import com.iths.DAO.PaymentDAO;
import com.iths.domain.pojo.Payment;
import com.iths.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentDAO.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentDAO.findByUserId(userId);
    }

    @Override
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentDAO.findByOrderId(orderId);
    }

    @Override
    public Payment updatePaymentStatus(Long paymentId, Integer payStatus) {
        Optional<Payment> optionalPayment = paymentDAO.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setPayStatus(payStatus);
            return paymentDAO.save(payment);
        } else {
            throw new RuntimeException("Payment not found");
        }
    }

}
