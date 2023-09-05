package shop.mtcoding.teamproject.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Company company = companyRepository.findByCompanyIdAndPassword(compLoginDTO.getCompanyId(),compLoginDTO.getPassword());
        return company;
    }
    
}
