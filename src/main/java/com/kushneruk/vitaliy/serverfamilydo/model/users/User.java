package com.kushneruk.vitaliy.serverfamilydo.model.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Persistable<Integer> {
    @Id
    Integer id;

    String firstName;

    String lastName;

    String email;

    String userName;

    String password;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
