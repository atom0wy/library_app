package pl.sda.library_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.library_app.enumerated.BookStatus;
import pl.sda.library_app.models.Book;
import pl.sda.library_app.models.User;

import java.util.List;

public interface CustomerRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where upper(first_name) like upper(?) and upper(last_name) like upper(?)", nativeQuery = true)
    List<User> findAllByFirstNameIgnoreCaseLikeAndLastNameIgnoreCaseLike(String name, String surname);

    @Query(value = "from user u where upper(p.firstName) like upper(?1) and upper(p.lastName) like upper(?2)", nativeQuery = true)
    List<User> filterByPersonName(String name, String surname);

    @Query(value = "select * from user where upper(email) like upper(?)", nativeQuery = true)
    List<User> findAllByEmailIgnoreCaseContains(String email);

    @Query(value = "select * from user where upper(address) like upper(?)", nativeQuery = true)
    List<User> findAllByAddressesCityIgnoreCase(String address);

    @Query(value = "select (count(u.id) > 0) from user u where upper(u.email) = upper(?1)", nativeQuery = true)
    boolean hasCustomerWithEmail(String email);
}
