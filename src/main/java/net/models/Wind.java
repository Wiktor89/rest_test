package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "winds")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind extends EssenceForId{

    @Column(name = "wind_chill")
    private Integer chill;

    @Column(name = "wind_direction")
    private Integer direction;

    @Column(name = "wind_speed")
    private Integer speed;

    public Integer getChill() {
        return chill;
    }

    public void setChill(Integer chill) {
        this.chill = chill;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
