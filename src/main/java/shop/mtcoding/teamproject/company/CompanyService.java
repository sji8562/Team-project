package shop.mtcoding.teamproject.company;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject._core.error.ex.MyException;
import shop.mtcoding.teamproject.announcement.Announcement;
import shop.mtcoding.teamproject.board.Board;
import shop.mtcoding.teamproject.company.CompanyRequest.UpdateDTO;
import shop.mtcoding.teamproject.company.CompanyRequest.compJoinDTO;
import shop.mtcoding.teamproject.company.CompanyRequest.companyLoginDTO;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public void compjoin(compJoinDTO joinDTO) {
        Company company = Company.builder()
                .companyId(joinDTO.getCompanyId())
                .companyName(joinDTO.getCompanyName())
                .password(joinDTO.getPassword())
                .email(joinDTO.getEmail())
                .address(joinDTO.getAddress())
                .addressDetail(joinDTO.getAddressDetail())
                .phoneNum(joinDTO.getPhoneNum())
                .homepage(joinDTO.getHomepage())
                .level(2)
                .build();

        companyRepository.save(company);
    }

    public Company companylogin(companyLoginDTO compLoginDTO) {
        System.out.println(compLoginDTO.getCompanyId());
        Company company = companyRepository.findByCompanyIdAndPassword(compLoginDTO.getCompanyId(),
                compLoginDTO.getPassword());
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

        company.setPassword(updateDTO.getPassword());
        company.setAddress(updateDTO.getAddress());
        company.setAddressDetail(updateDTO.getAddressDetail());
        company.setCompanyName(updateDTO.getCompanyName());
        company.setEmail(updateDTO.getEmail());
        company.setPhoneNum(updateDTO.getPhoneNum());
        company.setHomepage(updateDTO.getHomepage());

        return company;

    }

}
