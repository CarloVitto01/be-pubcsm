package com.example.pubcsm.controller;

import com.example.pubcsm.dto.OrderDTO;
import com.example.pubcsm.dto.OrderRequestDTO;
import com.example.pubcsm.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Create a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @Operation(summary = "Get an order by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.getOrderById(id);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get all orders")
    @ApiResponse(responseCode = "200", description = "List of orders")
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Operation(summary = "Update an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderRequestDTO orderRequestDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(id, orderRequestDTO);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @Operation(summary = "Delete an order by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
