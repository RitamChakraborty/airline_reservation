package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
public class UserChangePassword {
    String originalPassword;
    @NotBlank(message = "{error.userChangePassword.previousPassword}")
    private String previousPassword;
    @NotBlank(message = "{error.userChangePassword.newPassword}")
    @Pattern(regexp = "^((?=.*?[#?!@$%^&*-.]).{6,})?$", message = "{error.userChangePassword.newPassword.invalid}")
    private String newPassword;
    @NotBlank(message = "{error.userChangePassword.confirmPassword}")
    private String confirmPassword;

    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public String getPreviousPassword() {
        return previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
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
        return "UserChangePassword{" +
                "previousPassword='" + previousPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
