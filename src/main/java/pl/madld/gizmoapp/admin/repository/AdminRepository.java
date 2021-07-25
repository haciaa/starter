package pl.madld.gizmoapp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.madld.gizmoapp.admin.entity.Admin;

@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
