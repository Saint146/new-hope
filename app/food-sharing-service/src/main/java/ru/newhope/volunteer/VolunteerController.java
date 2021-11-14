package ru.newhope.volunteer;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Волонтёры")
public class VolunteerController {
    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping(value = "/volunteer")
    @ResponseBody
    public List<VolunteerEntity> getVolunteerList() {
        List<VolunteerEntity> volunteerList = volunteerRepository.findAll();
        return volunteerList;
    }

    @PostMapping(path="/volunteer/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setVolunteer(@RequestBody VolunteerEntity newVolunteer) {
        VolunteerEntity volunteer = volunteerRepository.save(newVolunteer);
        return new ResponseEntity<>(volunteer, HttpStatus.CREATED);
    }
}
