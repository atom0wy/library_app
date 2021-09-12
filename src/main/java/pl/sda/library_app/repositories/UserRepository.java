package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.library_app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select (count(u.USER_ID) > 0) from users u where upper(u.email) = upper(?1)", nativeQuery = true)
    boolean emailExist(String email);
}
