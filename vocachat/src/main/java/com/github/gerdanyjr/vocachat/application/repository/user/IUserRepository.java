package com.github.gerdanyjr.vocachat.application.repository.user;

import com.github.gerdanyjr.vocachat.core.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(Integer userId);
}
