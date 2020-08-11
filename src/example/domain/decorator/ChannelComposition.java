package example.domain.decorator;

import java.util.Map;

/**
 * @author Pominov Alexander
 */
public interface ChannelComposition {
    String getChannelId();
    void setChannelId(String channelId);
    String getDescription();
    void setDescription(String description);
    Map<String, Map<String, Object>> getColumnProjection();
}
