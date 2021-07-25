package pl.madld.gizmoapp.admin.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.madld.gizmoapp.admin.service.AdminService;
import pl.madld.gizmoapp.admin.entity.Admin;

@Component
public class AdminConverter implements Converter<String, Admin> {
    @Autowired
    private AdminService adminService;

    @Override
    public Admin convert(String string) {
        return adminService.findById(Long.valueOf(string)).orElse(null);
    }
}
