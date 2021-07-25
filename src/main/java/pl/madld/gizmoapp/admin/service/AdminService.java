package pl.madld.gizmoapp.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.madld.gizmoapp.admin.converter.AdminDTOConverter;
import pl.madld.gizmoapp.admin.dto.AdminCreateDTO;
import pl.madld.gizmoapp.admin.dto.AdminDTO;
import pl.madld.gizmoapp.admin.dto.AdminEditDTO;
import pl.madld.gizmoapp.admin.dto.AdminPassDTO;
import pl.madld.gizmoapp.admin.entity.Admin;
import pl.madld.gizmoapp.admin.repository.AdminRepository;
import pl.madld.gizmoapp.security.Role;
import pl.madld.gizmoapp.util.UtilService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminService {
    private final UtilService utilService;
    private final AdminRepository adminRepository;
    private final AdminDTOConverter adminDTOConverter;

    public boolean notExistAdmin() {
        return findAll().isEmpty();
    }

    public List<AdminDTO> findAll() {
        return adminRepository.findAll().stream()
                .map(admin -> adminDTOConverter.convertToDTO(admin))
                .collect(Collectors.toList());
    }

    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    public AdminEditDTO getAdminToEdit(Admin admin) {
        return adminDTOConverter.convertToEditDTO(admin);
    }

    public AdminPassDTO getAdminToPass(Admin admin) {
        return adminDTOConverter.convertToPassDTO(admin);
    }


    public void createAdmin(AdminCreateDTO adminCreateDTO) {
        Admin admin = adminDTOConverter.convert(adminCreateDTO);
        admin.setPassword(utilService.encodePassword(admin.getPassword()));
        admin.setUsername(adminCreateDTO.getFirstname() + " " + adminCreateDTO.getLastname());
        admin.setEnabled((short) 1);
        admin.setRole(Role.ROLE_ADMIN.toString());
        adminRepository.save(admin);
    }

    public void saveAdmin(AdminEditDTO admin, Admin baseAdmin) {
        baseAdmin.setEmail(admin.getEmail());
        baseAdmin.setFirstname(admin.getFirstname());
        baseAdmin.setLastname(admin.getLastname());
        baseAdmin.setUsername(admin.getFirstname() + " " + admin.getLastname());
        adminRepository.save(baseAdmin);
    }

    public void saveAdmin(AdminPassDTO admin, Admin baseAdmin) {
        baseAdmin.setPassword(utilService.encodePassword(admin.getPassword()));
        adminRepository.save(baseAdmin);
    }

    public void deleteAdmin(Admin admin) {
        adminRepository.delete(admin);
    }
}
