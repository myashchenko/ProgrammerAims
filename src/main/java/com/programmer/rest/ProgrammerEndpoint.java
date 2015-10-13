package com.programmer.rest;

import com.programmer.programmer.ProgrammerForm;
import com.programmer.rest.beans.ProgrammerCreateResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kolyan on 10/12/15.
 */
@RestController
@RequestMapping(value = "/api/programmer")
public class ProgrammerEndpoint {

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgrammerCreateResponse create(@RequestBody ProgrammerForm programmerForm) {
        ProgrammerCreateResponse programmerCreateResponse = new ProgrammerCreateResponse();
        return programmerCreateResponse;
    }
}