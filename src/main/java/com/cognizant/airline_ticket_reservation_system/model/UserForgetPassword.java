package com.cognizant.airline_ticket_reservation_system.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserForgetPassword {
    @NotNull(message = "{error.id}")
    private Integer id;
    @NotBlank(message = "{error.user.email}")
    @Email(message = "{error.user.email.invalid}")
    private String email;
    @NotBlank(message = "{error.user.phone}")
    @Pattern(regexp = "^(\\d{10})?$", message = "{error.user.phone.invalid}")
    private String phone;
    @NotBlank(message = "{error.userChangePassword.newPassword}")
    @Pattern(regexp = "^(.{6,})?$", message = "{error.userChangePassword.newPassword.invalid}")
    private String newPassword;
    @NotBlank(message = "{error.userChangePassword.confirmPassword}")
    private String confirmPassword;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserForgetPassword{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
