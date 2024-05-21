package com.sh.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor

public class MemberDto {

    private int memberId;
    private String name;
    private String userName;
    private String password;
    private Role role;
    private String phoneNumber;
    private String email;


    public MemberDto() {
    }

    public MemberDto(int memberId, String name, String userName, String password, Role role, String phoneNumber, String email) {
        this.memberId = memberId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public MemberDto(int memberId, String userName) {
        this.memberId = memberId;
        this.userName = userName;

        }


    public MemberDto(String password, int memberId){
        this.memberId = memberId;
        if(password != null){
            this.password = password;
        }

    }


    public MemberDto( String phoneNumber){
        this.phoneNumber = phoneNumber;

    }

  
    public MemberDto(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public MemberDto(int memberId, String name, String userName, String password, String phoneNumber, String email) {
        this.memberId = memberId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return "MemberDto{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


