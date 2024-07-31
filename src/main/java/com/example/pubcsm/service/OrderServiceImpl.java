package com.example.pubcsm.service;

import com.example.pubcsm.dto.OrderDTO;
import com.example.pubcsm.dto.OrderRequestDTO;
import com.example.pubcsm.model.Order;
import com.example.pubcsm.mapper.OrderMapper;
import com.example.pubcsm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderMapper.toEntity(orderRequestDTO);
        order = orderRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderRequestDTO orderRequestDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        // Aggiorna i dettagli dell'ordine
        order = orderMapper.toEntity(orderRequestDTO);
        order.setId(id); // Assicurati che l'ID non venga cambiato
        order = orderRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
