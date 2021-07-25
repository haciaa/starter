package pl.madld.gizmoapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.WebUtils;
import pl.madld.gizmoapp.util.Message;
import pl.madld.gizmoapp.util.MessageType;
import pl.madld.gizmoapp.util.UtilService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Set;

@RequiredArgsConstructor
@Controller
public class HomeController {
    public final UtilService utilService;

    @ModelAttribute("messages")
    public Set<Message> getMessages(HttpSession session, Model model) {
        return utilService.getMessages(session, model);
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/login/{effect}")
    public String loginPage(@PathVariable String effect, HttpSession session, Model model, HttpServletResponse response) {
        if(effect.equals("false")) {
            model.addAttribute("messages", Arrays.asList(new Message("message.login-error", MessageType.danger)));
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.invalidate();
        Cookie cookie = WebUtils.getCookie(request, "JSESSIONID");
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }
}
