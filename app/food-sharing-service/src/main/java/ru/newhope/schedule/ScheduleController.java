package ru.newhope.schedule;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Расписание")
public class ScheduleController {
    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping(value = "/schedule")
    @ResponseBody
    public List<ScheduleEntity> getCityList() {

        List<ScheduleEntity> cityList = scheduleRepository.findAll();
        return cityList;
    }
}

