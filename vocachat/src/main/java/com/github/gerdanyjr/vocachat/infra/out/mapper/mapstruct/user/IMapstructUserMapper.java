package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.user;

import com.github.gerdanyjr.vocachat.core.model.User;
import com.github.gerdanyjr.vocachat.infra.out.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapstructUserMapper {
    User fromEntityToModel(UserEntity userEntity);
}
