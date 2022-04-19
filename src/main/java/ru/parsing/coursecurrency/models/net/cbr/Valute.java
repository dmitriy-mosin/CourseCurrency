package ru.parsing.coursecurrency.models.net.cbr;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Valute {
    @XmlElement(name = "CharCode")
    private String currency;
    @XmlElement(name = "Value")
    private String rate;
}
