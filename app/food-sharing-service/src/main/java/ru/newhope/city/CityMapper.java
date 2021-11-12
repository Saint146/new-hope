package ru.newhope.city;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CityMapper extends ru.newhope.core.Mapper<CityEntity, CityDto> {
}