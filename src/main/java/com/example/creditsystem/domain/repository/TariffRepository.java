package com.example.creditsystem.domain.repository;

import com.example.creditsystem.data.entity.TariffEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends CrudRepository<TariffEntity, Long> {}
