package com.testblog.users.services;

import com.testblog.users.database.models.Role;
import com.testblog.users.database.models.User;

public final class UsersServiceObjectMapper {

    public static User convertServiceUserToDatabaseUser(final com.testblog.users.services.models.User user) {
        User result = null;
        if (user != null) {
            result = new User();
            result.setName(user.getName());
            result.setPassword(user.getPassword());
            result.setRole(convertServiceUserRoleToDatabaseUserRole(user.getRole()));
        }
        return result;
    }

    public static Role convertServiceUserRoleToDatabaseUserRole(final com.testblog.users.services.models.Role role) {
        switch (role) {
            case USER:
                return Role.USER;
            case ADMIN:
                return Role.ADMIN;
        }
        return null;
    }
}
