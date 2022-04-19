package ru.parsing.coursecurrency.models.db.cbr;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CourseCbr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private volatile Long id;

    @Column(name = "currency")
    private volatile String currency;

    @Column(name = "rate")
    private volatile double rate;
}
