package ru.parsing.coursecurrency.services.cbr;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.parsing.coursecurrency.models.net.cbr.ValCurs;
import ru.parsing.coursecurrency.models.net.cbr.Valute;

import java.util.List;

@Service
public class CourseCbrClient {
    public static final String URL = "https://cbr.ru/scripts/XML_daily.asp";
    final RestTemplate restTemplate = new RestTemplate();

    public List<Valute> getCourse() {
        return restTemplate.getForObject(URL, ValCurs.class).getValute();
    }
}
