package ma.visualiserr.repositories;

import ma.visualiserr.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Transactional
    @Modifying
    @Query("update Admin a set a.password = :password")
    int updatePasswordBy(String password);
    Optional<Admin> findByUsername(String username);
}
