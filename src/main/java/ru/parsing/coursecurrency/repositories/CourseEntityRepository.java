package ru.parsing.coursecurrency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.ecb.CourseEcb;

@Repository
public interface CourseEntityRepository extends JpaRepository<CourseEcb, Long> {
}