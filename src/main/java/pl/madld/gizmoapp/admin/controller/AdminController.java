package pl.madld.gizmoapp.admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.madld.gizmoapp.admin.dto.AdminCreateDTO;
import pl.madld.gizmoapp.admin.dto.AdminEditDTO;
import pl.madld.gizmoapp.admin.dto.AdminPassDTO;
import pl.madld.gizmoapp.admin.entity.Admin;
import pl.madld.gizmoapp.admin.service.AdminService;
import pl.madld.gizmoapp.security.CurrentUser;
import pl.madld.gizmoapp.util.Message;
import pl.madld.gizmoapp.util.MessageType;
import pl.madld.gizmoapp.util.UtilService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Set;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
@SessionAttributes({"sessionMessages", "baseAdminId"})
public class AdminController {
    private final UtilService utilService;
    private final AdminService adminService;

    private CurrentUser currentUser;

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        this.currentUser = currentUser;
        return currentUser;
    }
    @ModelAttribute("messages")
    public Set<Message> getMessages(HttpSession session, Model model) {
        return utilService.getMessages(session, model);
    }

    @GetMapping("")
    public String admin() {
        return "admin/home";
    }

    @GetMapping("/admins")
    public String getAdmins(Model model) {
        model.addAttribute("admins", adminService.findAll());
        return "admin/admins";
    }

    @GetMapping("/admin")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new AdminCreateDTO());
        return "admin/add";
    }
    @PostMapping("/admin")
    public String createAdmin(@ModelAttribute("admin") @Valid AdminCreateDTO adminCreateDTO, BindingResult result,
                              HttpSession session, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bindingResult", result);
            return "admin/add";
        }
        adminService.createAdmin(adminCreateDTO);
        utilService.addMessage(session, model, new Message("message.admin-add", MessageType.success));
        log.info(currentUser.getUsername() + " add admin: " + adminCreateDTO);
        return "redirect:/admin/admins";
    }

    @GetMapping("/admin/{admin}")
    public String editAdmin(@PathVariable Admin admin, Model model) {
        if (admin == null) {
            return "redirect:/admin/admins";
        }
        model.addAttribute("admin", adminService.getAdminToEdit(admin));
        model.addAttribute("baseAdminId", admin.getId());
        return "admin/edit";
    }
    @PostMapping("/admin/{baseAdmin}")
    public String saveAdmin(@ModelAttribute("admin") @Valid AdminEditDTO adminEditDTO, BindingResult result,
                            @PathVariable Admin baseAdmin, HttpSession session, Model model) {
        if (baseAdmin == null || baseAdmin.getId() != adminEditDTO.getId()
                || baseAdmin.getId() != session.getAttribute("baseAdminId")) {
            log.warn(currentUser.getUsername() + " try url manipulation in admin edit");
            return "redirect:/logout";
        }
        if (result.hasErrors()) {
            model.addAttribute("bindingResult", result);
            return "admin/edit";
        }
        adminService.saveAdmin(adminEditDTO, baseAdmin);
        utilService.addMessage(session, model, new Message("message.admin-save", MessageType.success));
        log.info(currentUser.getUsername() + " edit admin: " + baseAdmin);
        return "redirect:/admin/admins";
    }

    @GetMapping("/pass/{admin}")
    public String editAdminPass(@PathVariable Admin admin, Model model) {
        if (admin == null) {
            return "redirect:/admin/admins";
        }
        model.addAttribute("admin", adminService.getAdminToPass(admin));
        model.addAttribute("baseAdminId", admin.getId());
        return "admin/pass";
    }

    @PostMapping("/pass/{baseAdmin}")
    public String saveAdminPass(@ModelAttribute("admin") @Valid AdminPassDTO adminPassDTO, BindingResult result,
                                @PathVariable Admin baseAdmin, HttpSession session, Model model) {
        if (baseAdmin == null || baseAdmin.getId() != adminPassDTO.getId()
                || baseAdmin.getId() != session.getAttribute("baseAdminId")) {
            log.warn(currentUser.getUsername() + " try url manipulation in admin pass");
            return "redirect:/logout";
        }
        if (result.hasErrors()) {
            model.addAttribute("bindingResult", result);
            return "admin/pass";
        }
        adminService.saveAdmin(adminPassDTO, baseAdmin);
        log.info(currentUser.getUsername() + " change pass");
        return "redirect:/logout";
    }

    @GetMapping("/delete/{admin}")
    public String deleteAdmin(@PathVariable Admin admin, HttpSession session, Model model) {
        if (admin == null) {
            log.warn(currentUser.getUsername() + " try url manipulation in admin delete");
            return "redirect:/perform_logout";
        }
        adminService.deleteAdmin(admin);
        utilService.addMessage(session, model, new Message("message.admin-delete", MessageType.success));
        log.info(currentUser.getUsername() + " delete admin: " + admin);
        return "redirect:/admin/admins";
    }
}
