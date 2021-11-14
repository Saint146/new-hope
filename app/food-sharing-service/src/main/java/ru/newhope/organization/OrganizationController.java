package ru.newhope.organization;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Организации")
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping(value = "/organization")
    @ResponseBody
    public List<OrganizationEntity> getOrganizationList() {

        List<OrganizationEntity> organizationList = organizationRepository.findAll();
        return organizationList;
    }
}

