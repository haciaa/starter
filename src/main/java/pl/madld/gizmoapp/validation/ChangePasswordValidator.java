package pl.madld.gizmoapp.validation;

import pl.madld.gizmoapp.user.dto.UserPassDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChangePasswordValidator implements ConstraintValidator<ChangePassword, UserPassDTO> {
    @Override
    public void initialize(ChangePassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserPassDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (user.getOldPassword().equals(user.getPassword())) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.password.change-password}")
                    .addPropertyNode("password").addConstraintViolation();
            return false;
        }
        return true;
    }
}

