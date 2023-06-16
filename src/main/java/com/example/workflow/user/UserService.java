package com.example.workflow.user;

import com.example.workflow.user.dto.CreateUserDto;
import com.example.workflow.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserDto> findAll(UserSpecification workSpaceSpecification, Pageable pageable) {
        log.info("WorkSpace findAll");
        return userRepository.findAll(workSpaceSpecification, pageable).map(userMapper::toDto);
    }

    @Transactional
    public UserDto create(final CreateUserDto createUserDto) {
        log.info("WorkSpace create");
        final var createUser = userMapper.toEntity(createUserDto);
        return userMapper.toDto(userRepository.save(createUser));
    }
}
