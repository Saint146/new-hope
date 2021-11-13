package ru.newhope.volonteerorganization;

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
@Api(value = "Организации волонтёра")
public class VolunteerOrganizationController {
    @Autowired
    VolunteerOrganizationRepository volunteerOrganizationRepository;

    @PostMapping(path="/volunteer_organization", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrganizationById(@RequestBody VolunteerRequestParams volunteerRequestParams) {
        List<VolunteerOrganizationEntity> organizationList =
                volunteerOrganizationRepository.getByVolunteerId(volunteerRequestParams.getId());

        return new ResponseEntity<>(organizationList, HttpStatus.CREATED);
    }
}
