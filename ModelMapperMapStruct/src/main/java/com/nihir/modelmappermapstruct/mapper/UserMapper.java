package com.nihir.modelmappermapstruct.mapper;

import org.mapstruct.Mapper;
import com.nihir.modelmappermapstruct.domain.entity.User;
import com.nihir.modelmappermapstruct.domain.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
