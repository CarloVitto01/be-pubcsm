package com.example.pubcsm.service;

import com.example.pubcsm.dto.OrderDTO;
import com.example.pubcsm.dto.OrderRequestDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderRequestDTO orderRequestDTO);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    OrderDTO updateOrder(Long id, OrderRequestDTO orderRequestDTO);
    void deleteOrder(Long id);
}
