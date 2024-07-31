package com.example.pubcsm.mapper;

import com.example.pubcsm.dto.OrderDTO;
import com.example.pubcsm.dto.OrderRequestDTO;
import com.example.pubcsm.model.Order;
import com.example.pubcsm.model.Person;
import com.example.pubcsm.model.Product;
import com.example.pubcsm.repository.PersonRepository;
import com.example.pubcsm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setPersonId(order.getPerson().getId());
        dto.setProductIds(order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList())); // Modificato da Set a List
        return dto;
    }

    public Order toEntity(OrderRequestDTO orderRequestDTO) {
        if (orderRequestDTO == null) {
            return null;
        }

        Order order = new Order();
        Person person = personRepository.findById(orderRequestDTO.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));
        order.setPerson(person);

        List<Product> products = orderRequestDTO.getProductIds().stream()
                .map(productId -> productRepository.findById(productId)
                        .orElseThrow(() -> new RuntimeException("Product not found")))
                .collect(Collectors.toList()); // Modificato da Set a List
        order.setProducts(products);

        return order;
    }
}