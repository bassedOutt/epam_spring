package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.model.Pricing;
import com.epam.spring.homework3.service.repository.PricingRepository;
import org.springframework.stereotype.Repository;

@Repository
class PricingRepositoryImpl extends CrudRepositoryImpl<Pricing> implements PricingRepository {
}
