package com.cognizant.airline_ticket_reservation_system.validator;

import com.cognizant.airline_ticket_reservation_system.model.UserChangePassword;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserChangePasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserChangePassword.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "previousPassword", "error.userChangePassword.previousPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "error.userChangePassword.newPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.userChangePassword.confirmPassword");

        UserChangePassword userChangePassword = (UserChangePassword) target;
        String originalPassword = userChangePassword.getOriginalPassword();
        String previousPassword = userChangePassword.getPreviousPassword();
        String newPassword = userChangePassword.getNewPassword();
        String confirmPassword = userChangePassword.getConfirmPassword();

        if (!newPassword.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "error.userChangePassword.confirmPassword.notEqual");
        } else if (!originalPassword.equals(previousPassword)) {
            errors.rejectValue("previousPassword", "error.userChangePassword.previousPassword.notEqual");
        } else if (originalPassword.equals(newPassword)) {
            errors.rejectValue("newPassword", "error.userChangePassword.newPassword.equalsOld");
        }
    }
}
