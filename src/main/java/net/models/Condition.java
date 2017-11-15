package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "conditions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition extends EssenceForId{

    @Column(name = "condition_code")
    private Integer code;

    @Column(name = "condition_date")
    private String date;

    @Column(name = "condition_temp")
    private Integer temp;

    @Column(name = "condition_text")
    private String text;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
