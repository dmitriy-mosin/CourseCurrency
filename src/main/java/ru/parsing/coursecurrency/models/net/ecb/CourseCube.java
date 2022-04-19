package ru.parsing.coursecurrency.models.net.ecb;

import lombok.Data;
import ru.parsing.coursecurrency.models.db.ecb.CourseEcb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CourseCube {
        @XmlAttribute(name = "currency")
        private String currency;

        @XmlAttribute(name = "rate")
        private double rate;

        public String getCurrency() {
                return currency;
        }

        public void setCurrency(String currency) {
                this.currency = currency;
        }

        public double getRate() {
                return rate;
        }

        public void setRate(double rate) {
                this.rate = rate;
        }

        public CourseEcb mapper() {
                CourseEcb esb = new CourseEcb();
                esb.setCurrency(this.currency);
                esb.setRate(this.rate);

                return esb;
        }
}
