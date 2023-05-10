package com.example.creditsystem.domain.service.impl;

import com.example.creditsystem.domain.repository.TariffRepository;
import com.example.creditsystem.domain.service.TariffService;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import com.example.creditsystem.domain.service.model.ServiceError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TariffServiceImplementation implements TariffService {

    private final TariffRepository tariffRepository;
    @Override
    public ServiceAnswer getTariffs() {
        try{
            return new ServiceAnswer.Success<>(tariffRepository.findAll());
        } catch (Exception e){
            val error = ServiceError.ORDER_IMPOSSIBLE_TO_DELETE;
            return new ServiceAnswer.Error(error.getCode(), error.getMessage());
        }
    }
}
