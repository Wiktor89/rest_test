package net.models.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by VAfonin on 15.11.2017.
 */
@JsonRootName(value = "query")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonQuery {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("results")
    private JsonResults results;

}
