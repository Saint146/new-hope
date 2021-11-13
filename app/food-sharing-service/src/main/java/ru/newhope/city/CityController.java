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
    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/city")
    @ResponseBody
    public List<CityEntity> getCityList() {

        List<CityEntity> cityList = cityRepository.findAll();
        return cityList;
    }
}

