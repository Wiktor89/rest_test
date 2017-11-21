package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "forecasts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast extends EssenceForId{

    @Column(name = "forecast_date")
    private String date;

    @Column(name = "forecast_day")
    private String day;

    @Column(name = "forecast_high")
    private Integer high;

    @Column(name = "forecast_low")
    private Integer low;

    @Column(name = "forecast_text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "forecast_item")
    private Item item;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
