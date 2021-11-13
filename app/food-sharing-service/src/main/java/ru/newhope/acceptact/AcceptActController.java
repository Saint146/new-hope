package ru.newhope.acceptact;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.newhope.actitem.ActItemEntity;
import ru.newhope.actitem.ActItemRepository;


import java.util.List;


@RestController
@Api(value = "Акт приёма")
public class AcceptActController {
    @Autowired
    AcceptActRepository acceptActRepository;

    @Autowired
    ActItemRepository actItemRepository;

    @GetMapping(value = "/accept_act")
    @ResponseBody
    public List<AcceptActEntity> getActAcceptList() {

        List<AcceptActEntity> ActAcceptList = acceptActRepository.findAll();
        return ActAcceptList;
    }

    @PostMapping(path="/accept_act/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setVolunteer(@RequestBody AcceptActEntity newAcceptAct) {

        for (int i = newAcceptAct.getActItems().size() - 1; i > 0; i--) {
            if (newAcceptAct.getActItems().get(i).getAcceptanceActId() == null) {
                actItemRepository.delete(newAcceptAct.getActItems().get(i));
                newAcceptAct.getActItems().remove(i);
            }
        }

        AcceptActEntity acceptAct = acceptActRepository.save(newAcceptAct);

        return new ResponseEntity<>(acceptAct, HttpStatus.CREATED);
    }
}

