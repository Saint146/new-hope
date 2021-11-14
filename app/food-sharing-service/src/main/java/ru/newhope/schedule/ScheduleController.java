package ru.newhope.schedule;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value = "Расписание")
public class ScheduleController {
    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping(value = "/schedule")
    @ResponseBody
    public List<ScheduleEntity> getScheduleList() {

        List<ScheduleEntity> scheduleList = scheduleRepository.findAll();
        return scheduleList;
    }
}

