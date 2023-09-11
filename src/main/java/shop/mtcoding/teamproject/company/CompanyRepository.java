package shop.mtcoding.teamproject.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyIdAndPassword(String companyId, String password);
<<<<<<< HEAD

    Company findByCompanyId(String companyId);
=======
>>>>>>> 308a388930010861fe1a5d2c318575b24b7b4fa1

}
