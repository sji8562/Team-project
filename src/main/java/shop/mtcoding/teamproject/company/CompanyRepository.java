package shop.mtcoding.teamproject.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyIdAndPassword(String companyId, String password);

}