package com.ormispring.tdddemo.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유저 테스트")
public class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    public void testUserCreation() {
        // given
        User user = new User("max@gmail.com", "1234", "kim songjo");

        //then
        assertThat(user.getEmail()).isEqualTo("max@gmail.com");
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getName()).isEqualTo("kim songjo");
        assertThat(user.getId()).isNull();
        assertThat(user).isInstanceOf(User.class);
        assertThat(user.getPassword().length()).isEqualTo(4);
    }

}
