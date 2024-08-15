package com.ormispring.tdddemo;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
}