package ru.parsing.coursecurrency.models.domain;

import lombok.Data;

@Data
public class Course {

    private volatile String currency;
    private volatile double rate;
}
