package example.domain.decorator;

import example.domain.Attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pominov Alexander
 */
public class ChannelAttributes extends ColumnProjectionDecorator {

    private static final String OBJECT_ROOT_NODE_NAME = "channelAttributes";
    private static final String FIELD_SET_PARAM_NAME = "attributes";
    private static final String INCLUDE_SET_PARAM_NAME = "onlyFollowing";

    Boolean onlyFollowingAttributes = false;
    List<Attribute> attributes = new ArrayList<>();

    public ChannelAttributes(ChannelComposition channelComposition, List<Attribute> attributes, Boolean onlyFollowingAttributes) {
        super(channelComposition);
        this.attributes = attributes;
        this.onlyFollowingAttributes = onlyFollowingAttributes;
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public Boolean getOnlyFollowingAttributes() {
        return onlyFollowingAttributes;
    }

    public void setOnlyFollowingAttributes(Boolean onlyFollowingAttributes) {
        this.onlyFollowingAttributes = onlyFollowingAttributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
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
