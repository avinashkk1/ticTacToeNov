package dev.naman.factories;

import dev.naman.models.User;

public class UserFactory {
    public static User.Builder createUser() {
        return User.getBuilder();
    }
}
