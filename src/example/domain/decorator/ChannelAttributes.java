package example.domain.decorator;

import example.domain.Attribute;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pominov Alexander
 */
@Getter
@Setter
public class ChannelAttributes extends ColumnProjectionDecorator {

    private static final String OBJECT_ROOT_NODE_NAME = "channelAttributes";
    private static final String FIELD_SET_PARAM_NAME = "attributes";
    private static final String INCLUDE_SET_PARAM_NAME = "onlyFollowing";

    boolean onlyFollowingAttributes = false;
    List<Attribute> attributes = new ArrayList<>();

    public ChannelAttributes(ChannelComposition channelComposition, List<Attribute> attributes, Boolean onlyFollowingAttributes) {
        super(channelComposition);
        this.attributes = attributes;
        this.onlyFollowingAttributes = onlyFollowingAttributes;
    }

    @Override
    public Map<String, Map<String, Object>>  getColumnProjection() {
        Map<String, Object> channelAttributes = new HashMap<>();
        channelAttributes.put(FIELD_SET_PARAM_NAME, this.attributes);
        channelAttributes.put(INCLUDE_SET_PARAM_NAME, this.onlyFollowingAttributes);
        channelComposition.getColumnProjection().put(OBJECT_ROOT_NODE_NAME, channelAttributes);

        return channelComposition.getColumnProjection();
    }
}
