package ru.newhope.acceptact;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
@Api(value = "Акт приёма")
public class AcceptActController {
    @Autowired
    AcceptActRepository acceptActRepository;

    @GetMapping(value = "/accept_act")
    @ResponseBody
    public List<AcceptActEntity> getActAcceptList() {

        List<AcceptActEntity> ActAcceptList = acceptActRepository.findAll();
        return ActAcceptList;
    }

    @PostMapping(path="/accept_act/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setVolunteer(@RequestBody AcceptActEntity newAcceptAct) {
        AcceptActEntity acceptAct = acceptActRepository.save(newAcceptAct);
        return new ResponseEntity<>(acceptAct, HttpStatus.CREATED);
    }
}

