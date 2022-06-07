package com.testblog.users.services;

import com.testblog.users.commons.AbstractService;
import com.testblog.users.database.UsersMongoController;
import com.testblog.users.database.models.UserRepositoryResponse;
import com.testblog.users.exceptions.InternalServerErrorException;
import com.testblog.users.services.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends AbstractService {

    private final UsersMongoController usersMongoController;

    @Autowired
    public UsersService(final UsersMongoController usersMongoController) {
        this.usersMongoController = usersMongoController;
    }

    public void createUser(final User user) throws Exception {
        logger.info("Received a request to create a User {}", user);
        try {
            final UserRepositoryResponse databaseResponse = usersMongoController.save(UsersServiceObjectMapper.convertServiceUserToDatabaseUser(user));
            if (!databaseResponse.isSuccess()) {
                logger.error("Error while saving user {} : {}", user, databaseResponse.getErrorMessage());
                throw new InternalServerErrorException(databaseResponse.getErrorMessage());
            }
        } finally {
            logger.info("Finished creating user {}", user);
        }
    }
}
