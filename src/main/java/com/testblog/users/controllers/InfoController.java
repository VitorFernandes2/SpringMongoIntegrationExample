package com.testblog.users.controllers;

import com.testblog.users.Release;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Info Controller
 */
@RestController
public class InfoController {

    /**
     * Get users microservice version info
     *
     * @return {@link Void}
     * @throws Exception
     */
    @GetMapping(value = "/info")
    public ResponseEntity<Void> getInfo() throws Exception {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("testblog-users-ms-version", Release.getVersionInfo());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

}
