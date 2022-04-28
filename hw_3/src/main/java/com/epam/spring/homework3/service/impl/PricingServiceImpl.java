package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.PricingDto;
import com.epam.spring.homework3.dto.mapper.PricingMapper;
import com.epam.spring.homework3.exception.EntityNotFoundException;
import com.epam.spring.homework3.model.Pricing;
import com.epam.spring.homework3.service.PricingService;
import com.epam.spring.homework3.service.repository.PricingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
class PricingServiceImpl implements PricingService {

    private PricingRepository repository;
    private final PricingMapper mapper = PricingMapper.INSTANCE;

    @Autowired
    public void setRepository(PricingRepository repository) {
        this.repository = repository;
    }

    public List<PricingDto> getAll() {
        log.info("getting list of pricings");
        return repository.getAll().stream().map(mapper::pricingToPricingDto).collect(Collectors.toList());
    }

    public PricingDto getById(String id) {
        log.info("getting pricing with id {} ", id);
        return mapper.pricingToPricingDto(repository.getById(id));
    }

    public PricingDto insert(PricingDto entity) {
        log.info("inserting pricing: {}", entity);
        Pricing pricing = mapper.pricingDtoToPricing(entity);
        repository.insert(pricing);
        return entity;
    }

    public PricingDto update(PricingDto entity) {
        log.info("updating pricing: {}", entity);
        Pricing pricing = mapper.pricingDtoToPricing(entity);
        repository.update(pricing);
        return entity;
    }

    public void delete(String id) {
        log.info("deleting user with an id: {}", id);
        repository.delete(id);
    }

    @Override
    public PricingDto findByName(String name) {
        log.info("Searching for pricing with name: {}", name);
        return repository.getAll().stream()
                .filter(pricing -> pricing.getName().equals(name))
                .findFirst()
                .map(mapper::pricingToPricingDto)
                .orElseThrow(() -> new EntityNotFoundException("No pricing with name " + name + "were found"));
    }
}
