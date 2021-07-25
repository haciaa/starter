package pl.madld.gizmoapp.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.madld.gizmoapp.admin.service.AdminService;
import pl.madld.gizmoapp.user.repository.UserRepository;
import pl.madld.gizmoapp.user.entity.User;
import pl.madld.gizmoapp.util.UtilService;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final AdminService adminService;
    private final UtilService utilService;

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findByEmailAndEnabled(String email) {
        return userRepository.findByEmailAndEnabled(email, (short) 1);
    }

    public void activateUser(User user) {
        user.setEnabled((short) 1);
        user.setToken("");
        userRepository.save(user);
    }
}
