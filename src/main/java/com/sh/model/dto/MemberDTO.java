package com.sh.model.dto;

import com.sh.common.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class MemberDTO {
    private int memberId;
    private String name;
    private String userName; //ID
    private String password;
    private Role role;
    private String phoneNumber;
    private String email;
}
