package shop.mtcoding.teamproject.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyIdAndPassword(String companyId, String password);

    Company findByCompanyId(String companyId);

}