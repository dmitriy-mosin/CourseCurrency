package ru.parsing.coursecurrency.services.ecb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.parsing.coursecurrency.models.domain.Course;
import ru.parsing.coursecurrency.repositories.CourseApiRepository;

import java.util.List;

@Service
public class CourseEsbApi{

    private final CourseApiRepository courseApiRepository;

    @Autowired
    public CourseEsbApi(@Qualifier("courseEcbApiRepository") CourseApiRepository courseApiRepository) {
        this.courseApiRepository = courseApiRepository;
    }

    public List<Course> getCourseApi() {
        return courseApiRepository.getCourseApi();
    }
}
