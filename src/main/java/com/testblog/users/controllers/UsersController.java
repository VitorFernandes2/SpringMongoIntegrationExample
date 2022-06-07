package com.testblog.users.controllers;

import com.testblog.users.commons.AbstractController;
import com.testblog.users.exceptions.BadRequestException;
import com.testblog.users.services.UsersService;
import com.testblog.users.services.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Users Controller
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController extends AbstractController {

    private final UsersService usersService;

    @Autowired
    public UsersController(final UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody final User user) throws Exception {
        logger.info("Received request to create an User {}", user);
        try {
            if (user.getName() == null || user.getName().isBlank() ||
                    user.getPassword() == null || user.getPassword().isBlank() ||
                    user.getRole() == null) {
                throw new BadRequestException("Missing properties in User model.");
            }
            usersService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } finally {
            logger.info("Finished request to create User {}", user);
        }
    }
}
