package pl.madld.gizmoapp.validation;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.madld.gizmoapp.user.dto.UserCreateDTO;
import pl.madld.gizmoapp.user.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Setter
@RequiredArgsConstructor
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserCreateDTO> {
    private final UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserCreateDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (userService.findByEmail(user.getEmail()) != null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.email.email-unique}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        return true;
    }
}
