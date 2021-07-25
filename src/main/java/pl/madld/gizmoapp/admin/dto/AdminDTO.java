package pl.madld.gizmoapp.admin.dto;

import lombok.Data;
import pl.madld.gizmoapp.user.dto.UserDTO;

@Data
public class AdminDTO extends UserDTO {
    private String firstname;
    private String lastname;
}
