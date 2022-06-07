package com.testblog.users.database;

import com.testblog.users.database.models.User;
import com.testblog.users.database.models.UserRepositoryResponse;
import com.testblog.users.database.repository.UsersMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

@Component
public class UsersMongoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UsersMongoRepository usersMongoRepository;

    @Autowired
    public UsersMongoController(final UsersMongoRepository usersMongoRepository) {
        this.usersMongoRepository = usersMongoRepository;
    }

    public UserRepositoryResponse save(final User user) {
        logger.info("Started to save user in database User {}", user);
        final UserRepositoryResponse result = new UserRepositoryResponse();
        try {
            final User databaseUser = usersMongoRepository.save(user);
            result.setSuccess(true);
            result.setUser(databaseUser);
            return result;
        } catch (final DuplicateKeyException exception) {
            logger.error("Already existing name {}", exception.getMessage());
            result.setSuccess(false);
            result.setErrorMessage("Found other user with the same name in the database!");
            return result;
        } finally {
            logger.info("Finished to save user User {}", result);
        }
    }
}
