package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "images")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image extends EssenceForId{

    @Column(name = "image_title")
    private String title;

    @Column(name = "image_width")
    private Integer width;

    @Column(name = "image_height")
    private Integer height;

    @Column(name = "image_link")
    private String link;

    @Column(name = "image_url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
