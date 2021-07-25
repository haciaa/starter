package pl.madld.gizmoapp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ConfirmPasswordValidator.class, ConfirmChangePasswordValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPassword {
    String message() default "{invalid.password.confirm-password}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
