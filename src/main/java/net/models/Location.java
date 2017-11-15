package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "location")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location extends EssenceForId{

    @Column(name = "loc_city")
    private String city;

    @Column(name = "loc_country")
    private String country;

    @Column(name = "loc_region")
    private String region;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
