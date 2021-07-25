package pl.madld.gizmoapp.validation;

import pl.madld.gizmoapp.user.dto.UserCreateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, UserCreateDTO> {
    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserCreateDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.password.confirm-password}")
                    .addPropertyNode("confirmPassword").addConstraintViolation();
            return false;
        }
        return true;
    }
}
