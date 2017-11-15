package net.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by VAfonin on 15.11.2017.
 */
@Entity
@Table(name = "query")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Query extends EssenceForId {

    @Column(name = "query_count")
    private Integer count;

    @Column(name = "query_created")
    private String created;

    @Column(name = "query_lang")
    private String lang;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "query_results")
    private Results results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
