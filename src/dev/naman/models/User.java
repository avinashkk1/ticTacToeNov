package dev.naman.models;

import dev.naman.exceptions.InvalidEmailException;
import dev.naman.exceptions.InvalidUserNameException;

public class User {
    private String userName;
    private String email;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private User user;

        Builder() {
            this.user = new User();
        }

        public Builder seUserName(String userName) {
            this.user.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.user.email = email;
            return this;
        }

        public User build() {
            if (user.userName == null) {
                throw new InvalidUserNameException();
            }

            if (user.email == null) {
                throw new InvalidEmailException();
            }
            return user;
        }



    }


}
