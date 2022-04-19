package ru.parsing.coursecurrency.models.domain;

import lombok.Data;

@Data
public class Course {

    private String currency;
    private double rate;
}
