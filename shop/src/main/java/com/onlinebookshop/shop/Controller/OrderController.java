package com.onlinebookshop.shop.Controller;
 
import java.util.List;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.OrderService;
 
@Controller
@RequestMapping("/api")
public class OrderController {
 
    private final OrderService orderService;
 
    // Constructor-based dependency injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
 
    // Endpoint to fetch all orders
    @GetMapping("/orders")
    @ResponseBody
    public List<Order> fetchOrders() {
        return orderService.getAllOrders();
    }
 
    // Endpoint to fetch an order by its ID
    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order fetchOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
 
    // Endpoint to add a new order
    @PostMapping("/orders")
    @ResponseBody
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return "Order added successfully.";
    }
 
    // Endpoint to update an order
    @PutMapping("/orders")
    @ResponseBody
    public ResponseEntity<String> updateOrder(@RequestBody Order updatedOrder) {
        try {
            int rowsAffected = orderService.updateOrder(updatedOrder);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Order updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order.");
        }
    }
 
    // Endpoint to delete an order by its ID
    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        try {
            int rowsAffected = orderService.deleteOrder(id);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Order deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order.");
        }
    }
}
