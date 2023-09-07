package shop.mtcoding.teamproject.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserIdAndPassword(String userId, String password);

    User findByUserId(String userId);

}
