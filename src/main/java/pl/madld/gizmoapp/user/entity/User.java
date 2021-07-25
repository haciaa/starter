package pl.madld.gizmoapp.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name=User.USER_TYPE_COLUMN ,discriminatorType=DiscriminatorType.STRING)
public class User {
    public static final String TABLE_NAME = "users";
    public static final String USER_TYPE_COLUMN = "user_type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Short enabled;
    @Column(nullable = false, length = 11)
    private String role;
    @Column(nullable = false, length = 51)
    private String username;
    @Column(length = 32)
    private String token;
}
