package shop.mtcoding.teamproject.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject._core.vo.MyPath;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.board.Board;
import shop.mtcoding.teamproject.company.CompanyRequest.UpdateDTO;
import shop.mtcoding.teamproject.company.CompanyRequest.UpdatedetailDTO;
import shop.mtcoding.teamproject.company.CompanyRequest.compJoinDTO;
import shop.mtcoding.teamproject.company.CompanyRequest.companyLoginDTO;

@Service
public class CompanyService {

        @Autowired
        CompanyRepository companyRepository;

        public void compjoin(compJoinDTO joinDTO) {

                // 해시
                String encPassword = BCrypt.hashpw(joinDTO.getPassword(), BCrypt.gensalt());

                Company company = Company.builder()
                                .companyId(joinDTO.getCompanyId())
                                .companyName(joinDTO.getCompanyName())
                                .password(encPassword)
                                .email(joinDTO.getEmail())
                                .address(joinDTO.getAddress())
                                .addressDetail(joinDTO.getAddressDetail())
                                .phoneNum(joinDTO.getPhoneNum())
                                .homepage(joinDTO.getHomepage())
                                .level(2)
                                .build();

                System.out.println("해시 : " + encPassword);
                companyRepository.save(company);
        }

        public Company companylogin(companyLoginDTO compLoginDTO) {
                System.out.println(compLoginDTO.getCompanyId());
                Company company = companyRepository.findByCompanyId(compLoginDTO.getCompanyId());

                return company;
        }

        public Page<Company> 공고목록보기(Integer page) {
                Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, "index");
                Page<Company> pageContent = companyRepository.findAll(pageable);
                return pageContent;
        }

        @Transactional
        public Company 기업정보수정(UpdateDTO updateDTO, Integer id) {
                Company company = companyRepository.findById(id).get();

                // 해시
                String encPassword = BCrypt.hashpw(updateDTO.getPassword(), BCrypt.gensalt());
                company.setPassword(encPassword);

                // company.setPassword(updateDTO.getPassword());
                company.setAddress(updateDTO.getAddress());
                company.setAddressDetail(updateDTO.getAddressDetail());
                company.setCompanyName(updateDTO.getCompanyName());
                company.setEmail(updateDTO.getEmail());
                company.setPhoneNum(updateDTO.getPhoneNum());
                company.setHomepage(updateDTO.getHomepage());

                return company;

        }

        public Company 회원정보보기(Integer index) {
                return companyRepository.findById(index).get();
        }

        @Transactional
        public Company 기업디테일수정(UpdatedetailDTO updatedetailDTO, Integer id) {

                // // 프로젝트 실행 파일변경 -> blogv2-1.0.jar
                // // 해당 실행파일 경로에 images 폴더가 필요함
                // Path filePath = Paths.get(MyPath.IMG_PATH);
                // try {
                // Files.write(filePath, updatedetailDTO.getComppic().getBytes());
                // } catch (Exception e) {
                // throw new MyException(e.getMessage());
                // }

                // 영속화
                Company company = companyRepository.findById(id).get();

                // 변경
                company.setCompanyName(updatedetailDTO.getCompanyName());
                company.setEstablishment(updatedetailDTO.getEstablishment());
                company.setAddress(updatedetailDTO.getAddress());
                company.setAddressDetail(updatedetailDTO.getAddressDetail());
                company.setPhoneNum(updatedetailDTO.getPhoneNum());
                company.setEmail(updatedetailDTO.getEmail());
                company.setHomepage(updatedetailDTO.getHomepage());

                return company;
        }

        @Transactional
        public Company 상세보기(Integer id) {

                return companyRepository.findById(id).get();

        }

}
