package example.domain;

import example.domain.decorator.ChannelComposition;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pominov Alexander
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Channel implements ChannelComposition {
    private String channelId;
    private String description;
    private Map<String, Map<String, Object>> columnProjection = new HashMap<>();

    @Override
    public Map<String, Map<String, Object>> getColumnProjection() {
        return columnProjection;
    }

    @Override
    public String getChannelId() {
        return channelId;
    }

    @Override
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
