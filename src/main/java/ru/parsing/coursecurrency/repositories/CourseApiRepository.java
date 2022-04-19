package ru.parsing.coursecurrency.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseApiRepository<T> {
    List<T> getCourseApi();
}
