package shop.mtcoding.teamproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject.user.UserRequest.userJoinDTO;
import shop.mtcoding.teamproject.user.UserRequest.userLoginDTO;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    @Transactional
    public void usersave(userJoinDTO joinDTO) {
        User user = User.builder()
                .userid(joinDTO.getUserId())
                .username(joinDTO.getUsername())
                .password(joinDTO.getPassword())
                .email(joinDTO.getEmail())
                .address(joinDTO.getAddress())
                .addressDetail(joinDTO.getAddressDetail())
                .phoneNum(joinDTO.getPhoneNum())
                .level(1)
                .build();
        userRepository.save(user);
        
    }

    
    public User userlogin(userLoginDTO loginDTO) {
        User user = userRepository.findByUserIdAndPassword(loginDTO.getUserId(),loginDTO.getPassword());
        return user;
    }


    public void getKakaoAccessToken(String code) {
    }
    
    
}
