package com.github.gerdanyjr.vocachat.core.exception.impl.user;

import com.github.gerdanyjr.vocachat.core.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User not found!");
    }
}
