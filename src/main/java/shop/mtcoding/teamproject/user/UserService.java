package shop.mtcoding.teamproject.user;

import java.util.UUID;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject._core.vo.MyPath;
import shop.mtcoding.teamproject.board.Board;
import shop.mtcoding.teamproject.user.UserRequest.Kakaologin;
import shop.mtcoding.teamproject.user.UserRequest.OAuthToken;
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
                User user = userRepository.findByUserId(loginDTO.getUserId());
                return user;
        }

        @Transactional
        public User kakaologin(String code) throws JsonMappingException, JsonProcessingException {
                // POST방식으로 key=value 데이터를 요청(카카오쪽으로 )
                // Retrofit2 안드로이드에서 많이 씀
                // OkHttp
                // RestTemplate

                RestTemplate rt = new RestTemplate();

                // HttpHeader 오브젝트 생성
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

                // HttpBody 오브젝트 생성
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("grant_type", "authorization_code");
                params.add("client_id", "b72f0eb872a2a7ac5a3292bbd93c185c");
                params.add("redirect_uri", "http://localhost:8080/user/kakao");
                params.add("code", code);

                // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
                HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
                // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음
                ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST,
                                kakaoTokenRequest, String.class);

                ObjectMapper obMapper = new ObjectMapper();

                OAuthToken oauthToken = obMapper.readValue(response.getBody(), OAuthToken.class);

                RestTemplate rt2 = new RestTemplate();

                // HttpHeader 오브젝트 생성
                HttpHeaders headers2 = new HttpHeaders();
                headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
                headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

                // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
                HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);
                // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음
                ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST,
                                kakaoProfileRequest2, String.class);

                ObjectMapper obMapper2 = new ObjectMapper();
                Kakaologin kakaologin = null;
                kakaologin = obMapper2.readValue(response2.getBody(), Kakaologin.class);
                String kakaoid = kakaologin.getKakao_account().getEmail() + "_" + kakaologin.getId();
                // User 오브젝트 :username , password , email
                UUID garbagePW = UUID.randomUUID();

                // String salt = BCrypt.hashpw();
                // userRepository.findByUserIdAndPassword(kakaoid,)
                User user2 = userRepository.findByUserId(kakaoid);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                try {
                        if (user2 != null && !user2.equals("")) {
                                return user2;
                        } else {

                                User user = User.builder()
                                                .userid(kakaologin.getKakao_account().getEmail() + "_"
                                                                + kakaologin.getId())
                                                .email(kakaologin.getKakao_account().getEmail())
                                                .password(garbagePW.toString())
                                                .username(kakaologin.getKakao_account().getProfile().nickname)
                                                .build();

                                userRepository.save(user);
                                return user;
                        }
                } catch (Exception e) {

                        return user2;
                }
        }

        @Transactional
        public User 유저네임중복체크(String userId) {

                return userRepository.findByUsername(userId);

        }
}
