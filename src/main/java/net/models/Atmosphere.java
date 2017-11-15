package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "atmospheres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Atmosphere extends EssenceForId {

    @Column(name = "atmo_humidity")
    private Integer humidity;

    @Column(name = "atmo_pressure")
    private Float pressure;

    @Column(name = "atmo_rising")
    private Integer rising;

    @Column(name = "atmo_visibility")
    private Float visibility;

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Integer getRising() {
        return rising;
    }

    public void setRising(Integer rising) {
        this.rising = rising;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }
}
