package com.group4.service;

import com.group4.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IRevenueService {
    public long calculateDailyRevenue();
    public long calculateWeeklyRevenue();
    public long calculateMonthlyRevenue();
    public long calculateYearlyRevenue();
    public long calculateTotalRevenue();
    public long calculateRevenue(LocalDateTime startDate, LocalDateTime endDate);
    public double[] calculateMonthlyRevenueForYear();
    //public List<OrderEntity> getOrdersWithShippingStatusAndReceiveDate(LocalDateTime startDate, LocalDateTime endDate);
}
