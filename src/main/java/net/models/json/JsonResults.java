package net.models.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.models.Channel;

/**
 * Created by VAfonin on 15.11.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResults {

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
