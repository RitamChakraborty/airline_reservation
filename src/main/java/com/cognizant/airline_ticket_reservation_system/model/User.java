package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    @NotNull(message = "{error.user.age}")
    @Min(value = 19, message = "{error.user.age.young}")
    Integer age;
    @NotBlank(message = "{error.user.name}")
    @Size(min = 3, max = 20, message = "{error.user.name.size}")
    private String name;
    String gender;
    @Email(message = "{error.user.email}")
    private String email;
    @NotBlank(message = "{error.user.address}")
    private String address;
    @NotBlank(message = "{error.user.phone}")
    @Pattern(regexp = "^(\\d{10})?$")
    private String phone;
    private String secretQuestion;
    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getPassword().equals(user.getPassword()) &&
                getName().equals(user.getName()) &&
                getAge().equals(user.getAge()) &&
                getGender().equals(user.getGender()) &&
                getEmail().equals(user.getEmail()) &&
                getAddress().equals(user.getAddress()) &&
                getPhone().equals(user.getPhone()) &&
                getSecretQuestion().equals(user.getSecretQuestion()) &&
                getAnswer().equals(user.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassword(), getName(), getAge(), getGender(), getEmail(), getAddress(), getPhone(), getSecretQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
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
