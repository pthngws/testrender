package com.group4.service;

import com.group4.dto.PaymentDTO;
import com.group4.entity.PaymentEntity;
import jakarta.servlet.http.HttpServletRequest;

public interface IPaymentService {
    public String generateQr(int orderId, int amount);
    public PaymentDTO createVnPayPayment(HttpServletRequest request);
}
