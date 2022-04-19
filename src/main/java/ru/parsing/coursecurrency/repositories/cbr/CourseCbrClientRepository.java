package ru.parsing.coursecurrency.repositories.cbr;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.cbr.CourseCbr;
import ru.parsing.coursecurrency.models.net.cbr.Valute;
import ru.parsing.coursecurrency.repositories.CourseClientRepository;
import ru.parsing.coursecurrency.services.cbr.CourseCbrClient;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseCbrClientRepository implements CourseClientRepository {

    @Autowired
    private final CourseCbrClient courseCbrClient;

    @Override
    public List<CourseCbr> getCourseClient() {
        return courseCbrClient.getCourse().stream().map(this::convertToCourseCbr).collect(Collectors.toList());
    }

    private CourseCbr convertToCourseCbr(Valute valute) {
        CourseCbr courseCbr = new CourseCbr();
        courseCbr.setCurrency(valute.getCurrency());
        courseCbr.setRate(Double.parseDouble(valute.getRate().replace(",", ".")));

        return courseCbr;
    }
}
