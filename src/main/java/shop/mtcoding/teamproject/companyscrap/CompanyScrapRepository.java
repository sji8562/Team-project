package shop.mtcoding.teamproject.companyscrap;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyScrapRepository extends JpaRepository<CompanyScrap, Integer> {

    CompanyScrap findByResumeIdxAndCompIdx(Integer resumeIdx, Integer compIdx);

}
