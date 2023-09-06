package shop.mtcoding.teamproject.announcement;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class AnnouncementRequest {
    @Getter
    @Setter
    public static class SaveDTO{
        private String workType; //근무형태
        private String experience; //경력
        private String graduation; //학력
        private String task; //직무
        private String location; //근무지역
        private Timestamp startTime; //접수시작시간
        private Timestamp endTime;  //접수 마감시간
        private String salary; //급여
        private String skill; //기술
        private String preference; //우대조건
        private String manager; //대표자
        private String position; //직급
        private MultipartFile pic;
        private String workTime;
        private String workDay;  
    }

    @Getter
    @Setter
    public static class UpdateDTO{
        private String workType; //근무형태
        private String experience; //경력
        private String graduation; //학력
        private String task; //직무
        private String location; //근무지역
        private Timestamp startTime; //접수시작시간
        private Timestamp endTime;  //접수 마감시간
        private String salary; //급여
        private String preference; //우대조건
        private String manager; //대표자
        private String position; //직급
        private MultipartFile pic;
        private String workTime;
        private String workDay;  
    }
}
