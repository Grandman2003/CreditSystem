package com.example.creditsystem.presentation;

import com.example.creditsystem.domain.service.OrderService;
import com.example.creditsystem.domain.service.TariffService;
import com.example.creditsystem.domain.service.model.Order;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import com.example.creditsystem.domain.service.model.Tariff;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController implements LoanControllerOperations {

    private final TariffService tariffService;
    private final OrderService orderService;
    @Override
    public ResponseEntity<ServiceAnswer> getTariffs() {
        val tariffs =  tariffService.getTariffs();
        if(tariffs instanceof ServiceAnswer.Success<?>){
            return  ResponseEntity.ok(tariffs);
        } else {
            return ResponseEntity
                    .internalServerError()
                    .body(tariffs);
        }
    }

    @Override
    public ResponseEntity<ServiceAnswer> makeOrder(Tariff tariff) {
        val order =  orderService.makeOrder();
        if(order instanceof ServiceAnswer.Success<?>){
            return  ResponseEntity.ok(order);
        } else {
            return ResponseEntity
                    .internalServerError()
                    .body(order);
        }
    }

    @Override
    public ResponseEntity<ServiceAnswer> orderStatus(String orderId) {
        return null;
    }

    @Override
    public ResponseEntity<ServiceAnswer> deleteOrder(Order order) {
        return null;
    }
}
