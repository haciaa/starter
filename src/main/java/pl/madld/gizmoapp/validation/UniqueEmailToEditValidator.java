package pl.madld.gizmoapp.validation;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.madld.gizmoapp.user.dto.UserEditDTO;
import pl.madld.gizmoapp.user.entity.User;
import pl.madld.gizmoapp.user.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Setter
@RequiredArgsConstructor
@Component
public class UniqueEmailToEditValidator implements ConstraintValidator<UniqueEmail, UserEditDTO> {
    private final UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserEditDTO user, ConstraintValidatorContext constraintValidatorContext) {
        User existUser = userService.findByEmail(user.getEmail());
        if (existUser != null && existUser.getId() != user.getId()) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.email.email-unique}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        return true;
    }
}
