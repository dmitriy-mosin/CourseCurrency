package ru.parsing.coursecurrency.models.db.ecb;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@Data
public class CourseEcb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private volatile Long id;

    @Column(name = "currency")
    private volatile String currency;

    @Column(name = "rate")
    private volatile double rate;

}
