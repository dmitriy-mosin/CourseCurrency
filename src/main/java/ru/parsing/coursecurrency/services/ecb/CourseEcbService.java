package ru.parsing.coursecurrency.services.ecb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.parsing.coursecurrency.models.db.ecb.CourseEcb;
import ru.parsing.coursecurrency.repositories.CourseClientRepository;
import ru.parsing.coursecurrency.repositories.CourseEntityRepository;

import java.util.List;

@Service
@EnableScheduling
public class CourseEcbService {

    private final CourseEntityRepository courseEntityRepository;
    private final CourseClientRepository courseClientRepository;

    @Autowired
    public CourseEcbService(CourseEntityRepository courseEntityRepository, @Qualifier("courseEcbClientRepository") CourseClientRepository courseClientRepository) {
        this.courseEntityRepository = courseEntityRepository;
        this.courseClientRepository = courseClientRepository;
    }

    public List<CourseEcb> getCourse() {
        return courseEntityRepository.findAll();
    }

    @Scheduled(fixedDelayString = "${scheduled.interval}")
    public synchronized void updateCourseInfo() {
        List<CourseEcb> courseEcbList = courseClientRepository.getCourseClient();
        if (!courseEcbList.isEmpty()) {
            courseEntityRepository.deleteAll();
            courseEntityRepository.saveAll(courseEcbList);
        }
    }
}
