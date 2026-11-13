package com.korai.study04.repository;

import com.korai.study04.service.UserRoleService;
import com.korai.study04.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor // final 로 선택
public class UserRoleRepository {
    private final UserRoleService userRoleService;
    private UserService userService;
}
