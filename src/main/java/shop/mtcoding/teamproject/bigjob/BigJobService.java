package shop.mtcoding.teamproject.bigjob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mtcoding.teamproject.skill.Skill;

@Service
public class BigJobService {

    @Autowired
    BigJobRepository bigJobRepository;

    public List<BigJob> BigJobList() {
        System.out.println(bigJobRepository.findAll());
        return bigJobRepository.findAll();
    }
}
