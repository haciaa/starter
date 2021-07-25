package pl.madld.gizmoapp.admin.converter;

import org.springframework.stereotype.Component;
import pl.madld.gizmoapp.admin.dto.AdminCreateDTO;
import pl.madld.gizmoapp.admin.dto.AdminDTO;
import pl.madld.gizmoapp.admin.dto.AdminEditDTO;
import pl.madld.gizmoapp.admin.dto.AdminPassDTO;
import pl.madld.gizmoapp.admin.entity.Admin;

@Component
public class AdminDTOConverter {
    public Admin convert(AdminCreateDTO in) {
        Admin out = new Admin();
        out.setEmail(in.getEmail());
        out.setPassword(in.getPassword());
        out.setFirstname(in.getFirstname());
        out.setLastname(in.getLastname());
        return out;
    }

    public AdminDTO convertToDTO(Admin in) {
        if (in == null) {
            return null;
        }
        AdminDTO out = new AdminDTO();
        out.setId(in.getId());
        out.setEmail(in.getEmail());
        out.setFirstname(in.getFirstname());
        out.setLastname(in.getLastname());
        return out;
    }

    public AdminEditDTO convertToEditDTO(Admin in) {
        if (in == null) {
            return null;
        }
        AdminEditDTO out = new AdminEditDTO();
        out.setId(in.getId());
        out.setEmail(in.getEmail());
        out.setFirstname(in.getFirstname());
        out.setLastname(in.getLastname());
        return out;
    }

    public AdminPassDTO convertToPassDTO(Admin in) {
        if (in == null) {
            return null;
        }
        AdminPassDTO out = new AdminPassDTO();
        out.setId(in.getId());
        return out;
    }

}
