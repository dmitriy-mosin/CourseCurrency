package ru.parsing.coursecurrency.repositories.ecb;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.ecb.CourseEcb;
import ru.parsing.coursecurrency.models.domain.Course;
import ru.parsing.coursecurrency.repositories.CourseApiRepository;
import ru.parsing.coursecurrency.services.ecb.CourseEcbService;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseEcbApiRepository implements CourseApiRepository {

    @Autowired
    private final CourseEcbService courseEcbService;

    @Override
    public List<Course> getCourseApi() {
        return courseEcbService.getCourse().stream().map(this::convertToCourse).collect(Collectors.toList());
    }

    private Course convertToCourse(CourseEcb courseEcb) {
        Course course = new Course();
        course.setCurrency(courseEcb.getCurrency());
        course.setRate(courseEcb.getRate());
        return course;
    }
}
