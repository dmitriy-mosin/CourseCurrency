package ru.parsing.coursecurrency.services.ecb;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.parsing.coursecurrency.models.net.ecb.CourseCube;
import ru.parsing.coursecurrency.models.net.ecb.Envelope;

import java.util.List;

@Service
public class CourseEcbClient {
    public static final String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    final RestTemplate restTemplate = new RestTemplate();

    public List<CourseCube> getCourse() {
        return restTemplate.getForObject(URL, Envelope.class).getCubeMain().getCube().getCourseCubes();
    }
}
