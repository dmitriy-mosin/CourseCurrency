package ru.parsing.coursecurrency.repositories.ecb;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.ecb.CourseEcb;
import ru.parsing.coursecurrency.models.net.ecb.CourseCube;
import ru.parsing.coursecurrency.repositories.CourseClientRepository;
import ru.parsing.coursecurrency.services.ecb.CourseEcbClient;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseEcbClientRepository implements CourseClientRepository {

    @Autowired
    private final CourseEcbClient courseEcbClient;

    @Override
    public List<CourseEcb> getCourseClient() {
        return courseEcbClient.getCourse().stream().map(this::convertToCourseEcb).collect(Collectors.toList());
    }

    private CourseEcb convertToCourseEcb(CourseCube courseCube) {
        CourseEcb courseEcb = new CourseEcb();
        courseEcb.setCurrency(courseCube.getCurrency());
        courseEcb.setRate(courseCube.getRate());
        return courseEcb;
    }
}
