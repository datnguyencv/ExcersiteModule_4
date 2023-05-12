package com.example.register.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserDto implements Validator {

    private Integer id;
    @NotBlank
    @Size(min = 5, max = 45, message = "Bạn phải nhập độ dài từ 5 đến 45 ký tự")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Bạn phải nhập độ dài từ 5 đến 45 ký tự")
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^(098|097|093|091|094)\\d{7}$", message = "Số điện thoại phải bắt đầu 098|097|093|091|094 và tổng 10 số")
    private String phoneNumber;
    @NotBlank
    @Email(message = "email chưa đúng định dạng. VD: abc@email.com")
    private String email;
    @NotBlank
    private String dateOfBirth;

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, String email, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dateOfBirth = LocalDate.parse(user.getDateOfBirth(), formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(dateOfBirth, now).getYears();
            if (yearOld < 18) {
                errors.rejectValue("dateOfBirth", "Tuổi tối thiểu là 18 vui lòng kiểm tra lại");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "Định dạng ngày không hợp lệ, vui lòng kiểm tra lại");
        }
    }
}


