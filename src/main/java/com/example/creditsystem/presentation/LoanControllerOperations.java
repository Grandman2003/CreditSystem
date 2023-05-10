package com.example.creditsystem.presentation;

import com.example.creditsystem.domain.service.model.Order;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import com.example.creditsystem.domain.service.model.Tariff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan_service")
public interface LoanControllerOperations {
    @GetMapping("/getTariffs")
    ResponseEntity<ServiceAnswer> getTariffs();
    @PostMapping("/order")
    ResponseEntity<ServiceAnswer> makeOrder(@RequestBody Tariff tariff);
    @GetMapping("/getStatusOrder")
    ResponseEntity<ServiceAnswer> orderStatus(@RequestParam String orderId);
    @DeleteMapping("/deleteOrder")
    ResponseEntity<ServiceAnswer> deleteOrder(@RequestBody Order order);
}
