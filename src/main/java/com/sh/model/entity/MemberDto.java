package com.sh.model.entity;

public class MemberDto {

    private int memberId;
    private String name;
    private String userName;
    private String password;
    private Role role;
    private String phoneNumber;
    private String email;

    public MemberDto(String name, String userName, String password, Role role, String phoneNumber, String email) {
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
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
