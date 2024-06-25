package com.codegym.dto;

import javax.validation.constraints.*;

public class UserDto {

    private Long id;

    @NotBlank(message = "cannot be left blank")
    @Size(min = 5, max = 45, message = "Minimum length is 5 characters and minimum length is 45 characters")
    private String firstName;

    @NotBlank(message = "cannot be left blank")
    @Size(min = 5, max = 45, message = "Minimum length is 5 characters and minimum length is 45 characters")
    private String lastName;

    @NotBlank(message = "cannot be left blank")
    @Email(message = "Please enter the correct email format")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone numbers start from 0 and must have 10 digits")
    private String phoneNumber;

    @Min(value = 18, message = "must be 18 years old")
    private int age;

    public UserDto() {

    }

    public UserDto(Long id, String firstName, String lastName, String email, String phoneNumber, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
