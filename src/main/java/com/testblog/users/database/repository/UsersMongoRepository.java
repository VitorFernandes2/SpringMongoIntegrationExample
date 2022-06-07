package com.testblog.users.database.repository;

import com.testblog.users.database.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersMongoRepository extends MongoRepository<User, String> {

}
