package com.didi.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson()
    {
        return new PersonV1 ("Bob Marley");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson()
    {
        return new PersonV2(new Name("Bob","Marley"));
    }

    @GetMapping(path="/person/accept", produces= "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader()
    {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path="/person/accept", produces= "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader()
    {
        return new PersonV2(new Name("Bob","Marley"));
    }
}
