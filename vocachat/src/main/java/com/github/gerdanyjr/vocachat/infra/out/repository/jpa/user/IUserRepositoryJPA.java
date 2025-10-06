package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.user;

import com.github.gerdanyjr.vocachat.infra.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoryJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(Long userId);
}
