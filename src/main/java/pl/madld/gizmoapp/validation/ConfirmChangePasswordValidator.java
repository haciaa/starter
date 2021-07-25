package pl.madld.gizmoapp.validation;

import pl.madld.gizmoapp.user.dto.UserPassDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmChangePasswordValidator implements ConstraintValidator<ConfirmPassword, UserPassDTO> {
    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserPassDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.password.confirm-password}")
                    .addPropertyNode("confirmPassword").addConstraintViolation();
            return false;
        }
        return true;
    }
}
