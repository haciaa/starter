package pl.madld.gizmoapp.user.dto;

import lombok.Data;
import pl.madld.gizmoapp.validation.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@UniqueEmail
@Data
public class UserEditDTO {
    private Long id;
    @NotEmpty(message = "{invalid.email.not-empty}")
    @Email(message = "{invalid.email.email}")
    private String email;
}
