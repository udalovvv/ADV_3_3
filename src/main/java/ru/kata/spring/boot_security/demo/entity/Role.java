package ru.kata.spring.boot_security.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "role")
    @NonNull
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
