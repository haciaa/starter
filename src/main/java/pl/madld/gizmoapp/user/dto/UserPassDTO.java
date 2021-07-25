package pl.madld.gizmoapp.user.dto;

import lombok.Data;
import pl.madld.gizmoapp.validation.ChangePassword;
import pl.madld.gizmoapp.validation.ConfirmPassword;
import pl.madld.gizmoapp.validation.CurrentPassword;
import pl.madld.gizmoapp.validation.Password;

import javax.validation.constraints.NotEmpty;

@CurrentPassword
@ChangePassword
@ConfirmPassword
@Data
public class UserPassDTO {
    private Long id;
    @NotEmpty(message = "{invalid.old-password.not-empty}")
    private String oldPassword;
    @Password
    private String password;
    private String confirmPassword;
}
