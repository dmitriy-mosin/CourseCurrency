package ru.parsing.coursecurrency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.parsing.coursecurrency.models.db.cbr.CourseCbr;

@Repository
public interface CourseCbrEntityRepository extends JpaRepository<CourseCbr, Long> {
}
