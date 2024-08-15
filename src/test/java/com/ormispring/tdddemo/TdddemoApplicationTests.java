package com.ormispring.tdddemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ormispring.tdddemo.controller.UserRegistrationDto;
import com.ormispring.tdddemo.entity.User;
import com.ormispring.tdddemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class TdddemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired private UserRepository userRepository;

    @Autowired private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testUserRegistrationAndRetrieval() throws Exception {
        // 1. 사용자 등록
        String email = "test@example.com";
        String password = "password123";
        String name = "Test User";

        String userJson =
                objectMapper.writeValueAsString(new UserRegistrationDto(email, password, name));

        mockMvc
                .perform(
                        post("/api/users/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userJson)
                                .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.name").value(name));

        // 2. 등록된 사용자 조회
        mockMvc
                .perform(get("/api/users/" + email).with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.name").value(name));

        // 3. 데이터베이스에서 직접 확인
        User savedUser = userRepository.findByEmail(email);
//    assert savedUser != null;
        assertThat(savedUser).isNotNull();

//    assert savedUser.getEmail().equals(email);
        assertThat(savedUser.getEmail()).isEqualTo(email);

//    assert savedUser.getName().equals(name);
        assertThat(savedUser.getName()).isEqualTo(name);
    }

}
