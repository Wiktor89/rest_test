package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends EssenceForId{

    @Column(name = "item_title")
    private String title;

    @Column(name = "item_lat")
    private Double lat;

    @Column(name = "item_long")
    private Double longitude;

    @Column(name = "item_link")
    private String link;

    @Column(name = "item_pub_date")
    private String pubDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_condition")
    private Condition condition;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Forecast> forecasts;

    @Column(name = "item_desc")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Set<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(Set<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
