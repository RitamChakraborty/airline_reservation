package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "{error.password}")
    private String password;
    @NotBlank(message = "{error.user.name}")
    private String name;
    @Email(message = "{error.user.email}")
    private String email;
    @NotBlank(message = "{error.user.address}")
    private String address;
    @NotBlank(message = "{error.user.phone}")
    @Pattern(regexp = "^(\\d{10})?$", message = "{error.user.phone.invalid}")
    private String phone;
    private String secretQuestion;
    @NotBlank(message = "${error.user.answer}")
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
                getEmail().equals(user.getEmail()) &&
                getAddress().equals(user.getAddress()) &&
                getPhone().equals(user.getPhone()) &&
                getSecretQuestion().equals(user.getSecretQuestion()) &&
                getAnswer().equals(user.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassword(), getName(), getEmail(), getAddress(), getPhone(), getSecretQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
