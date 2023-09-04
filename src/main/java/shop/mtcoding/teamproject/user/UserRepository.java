package shop.mtcoding.teamproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUserIdAndPassword(String userId, String password);
<<<<<<< HEAD

    User findByUserId(String userId);
=======
>>>>>>> Skilltb2
}
