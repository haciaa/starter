package pl.madld.gizmoapp.admin.dto;

import lombok.Data;
import pl.madld.gizmoapp.user.dto.UserEditDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AdminEditDTO extends UserEditDTO {
    @NotNull
    @Size(min = 3, max = 20, message = "{invalid.firstname.size}")
    private String firstname;
    @NotNull
    @Size(min = 3, max = 30, message = "{invalid.lastname.size}")
    private String lastname;
}
