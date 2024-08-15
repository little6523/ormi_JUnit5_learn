package com.ormispring.tdddemo.repository;

import com.ormispring.tdddemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.yml")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        User newUser = new User("test@example.com", "password", "Test User");
        entityManager.persist(newUser);
        entityManager.flush();

        User found = userRepository.findByEmail(newUser.getEmail());

        assertThat(found.getName()).isEqualTo(newUser.getName());
        assertThat(found.getEmail()).isEqualTo(newUser.getEmail());
    }

    @Test
    public void testSaveUser() {
        User user = new User("save@example.com", "password", "Save User");
        User savedUser = userRepository.save(user);

        assertThat(savedUser).hasFieldOrPropertyWithValue("email", "save@example.com");
        assertThat(savedUser).hasFieldOrPropertyWithValue("name", "Save User");
    }

    @Test
    public void testFindUserById() {
        User user = new User("find@example.com", "password", "Find User");
        entityManager.persist(user);
        entityManager.flush();

        User found = userRepository.findById(user.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo(user.getEmail());
        assertThat(found.getName()).isEqualTo(user.getName());
    }

}
