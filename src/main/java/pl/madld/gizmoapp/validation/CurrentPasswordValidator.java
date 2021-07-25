package pl.madld.gizmoapp.validation;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.madld.gizmoapp.user.dto.UserPassDTO;
import pl.madld.gizmoapp.user.service.UserService;
import pl.madld.gizmoapp.util.UtilService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Setter
@RequiredArgsConstructor
@Component
public class CurrentPasswordValidator implements ConstraintValidator<CurrentPassword, UserPassDTO> {
    private final UserService userService;
    private final UtilService utilService;

    @Override
    public void initialize(CurrentPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserPassDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (!user.getOldPassword().isEmpty() && !utilService.matchPassword(user.getOldPassword(), userService.findById(user.getId()))) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.old-password.not-equals}")
                    .addPropertyNode("oldPassword").addConstraintViolation();
            return false;
        }
        return true;
    }
}
