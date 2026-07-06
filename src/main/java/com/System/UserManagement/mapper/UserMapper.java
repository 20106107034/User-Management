package com.System.UserManagement.mapper;



import com.System.UserManagement.Dto.UserRequest;
import com.System.UserManagement.Dto.UserResponse;
import com.System.UserManagement.Model.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();
    }

    public static UserResponse toResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }
}
