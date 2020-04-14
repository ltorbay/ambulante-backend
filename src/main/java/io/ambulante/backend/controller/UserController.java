package io.ambulante.backend.controller;

import io.ambulante.backend.model.dto.User;
import io.ambulante.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Page<User> findAll(@PageableDefault Pageable pageable) {
        return userRepository.findAllProjectedBy(pageable);
    }
}
