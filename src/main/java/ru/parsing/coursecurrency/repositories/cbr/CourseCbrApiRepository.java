package ru.parsing.coursecurrency.repositories.cbr;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.cbr.CourseCbr;
import ru.parsing.coursecurrency.models.domain.Course;
import ru.parsing.coursecurrency.repositories.CourseApiRepository;
import ru.parsing.coursecurrency.services.cbr.CourseCbrService;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseCbrApiRepository implements CourseApiRepository {

    @Autowired
    private final CourseCbrService courseCbrService;

    @Override
    public List<Course> getCourseApi() {
        return courseCbrService.getCourse().stream().map(this::convertToCourse).collect(Collectors.toList());
    }

    private Course convertToCourse(CourseCbr courseCbr) {
        Course course = new Course();
        course.setCurrency(courseCbr.getCurrency());
        course.setRate(courseCbr.getRate());
        return course;
    }
}
