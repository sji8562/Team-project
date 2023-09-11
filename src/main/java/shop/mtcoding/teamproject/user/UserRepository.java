package shop.mtcoding.teamproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserIdAndPassword(String userId, String password);

    User findByUserId(String userId);

    @Query(value = "select u from User u where u.userId = :id")
    User findByUsername(@Param("id") String userId);

}

// insert,update, delete는 JPQL사용 못함
