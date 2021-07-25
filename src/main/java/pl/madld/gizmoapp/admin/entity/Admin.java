package pl.madld.gizmoapp.admin.entity;

import lombok.Data;
import pl.madld.gizmoapp.user.entity.User;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Admin.TABLE_NAME)
@DiscriminatorValue(Admin.USER_TYPE)
public class Admin extends User {
    public static final String TABLE_NAME = "admins";
    public static final String USER_TYPE = "admin";

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
}
