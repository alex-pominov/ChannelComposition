package example.domain.decorator;

import java.util.Map;

/**
 * @author Pominov Alexander
 */
public class ColumnProjectionDecorator implements ChannelComposition {
    protected ChannelComposition channelComposition;

    public ColumnProjectionDecorator(ChannelComposition channelComposition) {
        this.channelComposition = channelComposition;
    }

    @Override
    public String getChannelId() {
        return channelComposition.getChannelId();
    }

    @Override
    public void setChannelId(String channelId) {
        channelComposition.setChannelId(channelId);
    }

    @Override
    public String getDescription() {
        return channelComposition.getDescription();
    }

    @Override
    public void setDescription(String description) {
        channelComposition.setDescription(description);
    }

    @Override
    public Map<String, Map<String, Object>> getColumnProjection() {
        return channelComposition.getColumnProjection();
    }

    @Override
    public String toString() {
        return "Channel {" +
                "channelId='" + channelComposition.getChannelId() + '\'' +
                ", description='" + channelComposition.getDescription() + '\'' +
                ", columnProjection=" + channelComposition.getColumnProjection() +
                '}';
    }
}
