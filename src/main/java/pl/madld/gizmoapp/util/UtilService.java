package pl.madld.gizmoapp.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pl.madld.gizmoapp.user.entity.User;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class UtilService {
    private final BCryptPasswordEncoder passwordEncoder;

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Boolean matchPassword(String password, User user) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    public Set<Message> getMessages(HttpSession session, Model model) {
        Set<Message> sessionMesssages = (Set<Message>) session.getAttribute("sessionMessages");
        Set<Message> messages = new HashSet<>();
        if (sessionMesssages != null && sessionMesssages.size() != 0) {
            messages = sessionMesssages;
            model.addAttribute("sessionMessages", new HashSet<String>());
        }
        return messages;
    }

    public void addMessage(HttpSession session, Model model, Message message) {
        Set<Message> sessionMesssages = (Set<Message>) session.getAttribute("sessionMessages");
        if (sessionMesssages == null) {
            sessionMesssages = new HashSet<>();
        }
        sessionMesssages.add(message);
        model.addAttribute("sessionMessages", sessionMesssages);
    }
}
