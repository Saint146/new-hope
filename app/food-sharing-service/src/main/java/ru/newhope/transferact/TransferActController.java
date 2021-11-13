package ru.newhope.transferact;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Акт передачи")
public class TransferActController {
    @Autowired
    TransferActRepository transferActRepository;

    @GetMapping(value = "/transfer_act")
    @ResponseBody
    public List<TransferActEntity> getTransferActList() {

        List<TransferActEntity> transferActList = transferActRepository.findAll();
        return transferActList;
    }

    @PostMapping(path="/transfer_act/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setVolunteer(@RequestBody TransferActEntity newTransferAct) {
        TransferActEntity transferAct = transferActRepository.save(newTransferAct);
        return new ResponseEntity<>(transferAct, HttpStatus.CREATED);
    }
}

