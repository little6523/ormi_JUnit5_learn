package pre;

import lombok.Getter;

@Getter
public class User {

    private String name;

    public User(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름은 2자 이상이어야합니다.");
        }
        this.name = name;
    }
}
