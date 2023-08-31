package shop.mtcoding.teamproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject.user.UserRequest.userJoinDTO;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    // private String userId;
    // private String password;
    // private String email;
    // private String username;
    // private String address;
    // private String addressDetail;
    // private String phoneNum;
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
    
}
