package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class UserRegistration {
    @NotBlank(message = "{error.user.name}")
    private String name;
    @NotNull(message = "{error.user.age}")
    @Min(value = 19, message = "{error.user.age.young}")
    Integer age;
    @NotBlank(message = "{error.user.confirmPassword}")
    private String confirmPassword;
    String gender;
    @NotBlank(message = "{error.password}")
    @Pattern(regexp = "^((?=.*?[#?!@$%^&*-]).{6,})?$", message = "{error.user.password.invalid}")
    private String password;
    @NotBlank(message = "{error.user.email}")
    @Email(message = "{error.user.email.invalid}")
    private String email;
    @NotBlank(message = "{error.user.address}")
    private String address;
    @NotBlank(message = "{error.user.phone}")
    @Pattern(regexp = "^(\\d{10})?$", message = "{error.user.phone.invalid}")
    private String phone;
    private String secretQuestion;
    @NotBlank(message = "{error.user.answer}")
    private String answer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
