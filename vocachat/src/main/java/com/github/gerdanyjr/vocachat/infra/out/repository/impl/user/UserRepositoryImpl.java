package com.github.gerdanyjr.vocachat.infra.out.repository.impl.user;

import com.github.gerdanyjr.vocachat.application.repository.user.IUserRepository;
import com.github.gerdanyjr.vocachat.core.model.User;
import com.github.gerdanyjr.vocachat.infra.out.entity.UserEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.user.IMapstructUserMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.user.IUserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements IUserRepository {
    private final IUserRepositoryJPA userRepositoryJpa;
    private final IMapstructUserMapper mapper;

    @Override
    public Optional<User> findById(Long userId) {
        UserEntity foundUser = userRepositoryJpa.findByUserId(userId);
        return Optional.ofNullable(mapper.fromEntityToModel(foundUser));
    }
}
