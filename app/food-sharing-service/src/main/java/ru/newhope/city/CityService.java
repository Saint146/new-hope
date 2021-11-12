package ru.newhope.city;

import org.springframework.stereotype.Service;
import ru.newhope.core.service.AbstractServiceImpl;

@Service
public class CityService extends AbstractServiceImpl<
    String,
    CityDto,
    CityEntity,
    CityRepository,
    CityMapper> {

    public CityService(CityRepository repository, CityMapper mapper) { super(repository, mapper); }
}

