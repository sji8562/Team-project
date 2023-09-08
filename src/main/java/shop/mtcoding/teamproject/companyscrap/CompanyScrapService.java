package shop.mtcoding.teamproject.companyscrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.teamproject.companyscrap.CompanyScrapRequest.bookCompanySaveDTO;

@Service
public class CompanyScrapService {

    @Autowired
    private CompanyScrapRepository companyScrapRepository;

    @Transactional
    public void savecompanyScrap(bookCompanySaveDTO bcSaveDTO) {
        System.out.println("들어오긴 하냐");
        System.out.println(bcSaveDTO.getCompIdx());
        System.out.println(bcSaveDTO.getResumeIdx());
        CompanyScrap companyScrap = CompanyScrap.builder()
                .resumeIdx(bcSaveDTO.getResumeIdx())
                .compIdx(bcSaveDTO.getCompIdx())
                .build();
        System.out.println("들어오긴 하냐");
        companyScrapRepository.save(companyScrap);
    }

    public boolean isBookmarkSaved(Integer resumeIdx, Integer compIdx) {
        CompanyScrap companyScrap = companyScrapRepository.findByResumeIdxAndCompIdx(resumeIdx, compIdx);

        return companyScrap != null;
    }

    @Transactional
    public void deleteCompanyScrap(Integer resumeIdx, Integer compIdx) {
        CompanyScrap companyScrap = companyScrapRepository.findByResumeIdxAndCompIdx(resumeIdx, compIdx);
        if (companyScrap != null) {
            companyScrapRepository.delete(companyScrap);
        }
    }
}
