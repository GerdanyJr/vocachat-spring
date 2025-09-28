package com.github.gerdanyjr.vocachat.core.exception.user;

import com.github.gerdanyjr.vocachat.core.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User not found!");
    }
}
