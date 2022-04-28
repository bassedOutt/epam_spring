package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.PricingDto;
import com.epam.spring.homework3.model.Pricing;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricingMapper {
    PricingMapper INSTANCE = Mappers.getMapper(PricingMapper.class);
    PricingDto pricingToPricingDto(Pricing pricing);
    Pricing pricingDtoToPricing(PricingDto pricing);
}
