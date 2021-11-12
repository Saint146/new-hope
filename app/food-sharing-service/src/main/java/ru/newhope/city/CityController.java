package ru.newhope.city;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Города")
public class CityController {
    //private final AbstractService<CityDto> service;

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/city")
    public @ResponseBody
    List<CityEntity> getCityList() {

        List<CityEntity> cityList = cityRepository.findAll();
        return cityList;
    }
}

