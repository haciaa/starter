package pl.madld.gizmoapp.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.madld.gizmoapp.admin.dto.AdminCreateDTO;
import pl.madld.gizmoapp.admin.service.AdminService;
import pl.madld.gizmoapp.user.service.UserService;
import pl.madld.gizmoapp.util.Message;
import pl.madld.gizmoapp.util.UtilService;

import javax.servlet.http.HttpSession;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class UserController {
    public final UtilService utilService;
    public final UserService userService;
    public final AdminService adminService;

    @ModelAttribute("messages")
    public Set<Message> getMessages(HttpSession session, Model model) {
        return utilService.getMessages(session, model);
    }

    @GetMapping("/admin-create")
    public String createAdmin() {
        if (adminService.notExistAdmin()) {
            AdminCreateDTO admin = new AdminCreateDTO();
            admin.setEmail("admin@starter.pl");
            admin.setPassword("admin456");
            admin.setFirstname("Admin");
            admin.setLastname("Adminowski");
            adminService.createAdmin(admin);
        }
        return "redirect:/admin/";
    }
}
