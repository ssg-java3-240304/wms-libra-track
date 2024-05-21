package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private int memberId;
    private String name;
    private String userName;
    private String password;
    private Role role;
    private String phoneNumber;
    private String email;

    public MemberDto(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}
