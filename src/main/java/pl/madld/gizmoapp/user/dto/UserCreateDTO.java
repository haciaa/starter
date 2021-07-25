package pl.madld.gizmoapp.user.dto;

import lombok.Data;
import pl.madld.gizmoapp.validation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@ConfirmPassword
@UniqueEmail
public class UserCreateDTO {
    @NotEmpty(message = "{invalid.email.not-empty}")
    @Email(message = "{invalid.email.email}")
    private String email;
    @Password
    private String password;
    private String confirmPassword;
}
