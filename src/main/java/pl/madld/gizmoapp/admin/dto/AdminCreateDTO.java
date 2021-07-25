package pl.madld.gizmoapp.admin.dto;

import lombok.Data;
import pl.madld.gizmoapp.user.dto.UserCreateDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AdminCreateDTO extends UserCreateDTO {
    @NotNull
    @Size(min = 3, max = 20, message = "{invalid.firstname.size}")
    private String firstname;
    @NotNull
    @Size(min = 3, max = 30, message = "{invalid.lastname.size}")
    private String lastname;
}
