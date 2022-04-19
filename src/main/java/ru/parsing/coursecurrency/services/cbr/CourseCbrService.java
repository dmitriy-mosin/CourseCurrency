package ru.parsing.coursecurrency.services.cbr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.parsing.coursecurrency.models.db.cbr.CourseCbr;
import ru.parsing.coursecurrency.repositories.CourseCbrEntityRepository;
import ru.parsing.coursecurrency.repositories.CourseClientRepository;

import java.util.List;

@Service
@EnableScheduling
public class CourseCbrService {

    private final CourseCbrEntityRepository courseCbrEntityRepository;
    private final CourseClientRepository courseClientRepository;

    @Autowired
    public CourseCbrService(CourseCbrEntityRepository courseCbrEntityRepository, @Qualifier("courseCbrClientRepository") CourseClientRepository courseClientRepository) {
        this.courseCbrEntityRepository = courseCbrEntityRepository;
        this.courseClientRepository = courseClientRepository;
    }

    public List<CourseCbr> getCourse() {
        return courseCbrEntityRepository.findAll();
    }

    @Scheduled(fixedDelayString = "${scheduled.interval}")
    public synchronized void updateCourseInfo() {
        List<CourseCbr> courseCbrList = courseClientRepository.getCourseClient();
        if (!courseCbrList.isEmpty()) {
            courseCbrEntityRepository.deleteAll();
            courseCbrEntityRepository.saveAll(courseCbrList);
        }
    }
}
