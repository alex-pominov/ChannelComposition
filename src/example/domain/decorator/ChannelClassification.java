package example.domain.decorator;

import example.domain.Attribute;
import example.domain.Classification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pominov Alexander
 */
public class ChannelClassification extends ColumnProjectionDecorator {

    private static final String OBJECT_ROOT_NODE_NAME = "channelClassifications";
    private static final String FIELD_SET_PARAM_NAME = "classifications";
    private static final String INCLUDE_SET_PARAM_NAME = "onlyFollowing";

    Boolean onlyFollowingClassifications = false;
    List<Classification> classifications = new ArrayList<>();

    public ChannelClassification(ChannelComposition channelComposition, List<Classification> classifications, Boolean onlyFollowingClassifications) {
        super(channelComposition);
        this.onlyFollowingClassifications = onlyFollowingClassifications;
        this.classifications = classifications;
    }

    public void addClassification(Classification classification) {
        classifications.add(classification);
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public Boolean getOnlyFollowingClassifications() {
        return onlyFollowingClassifications;
    }

    public void setOnlyFollowingClassifications(Boolean onlyFollowingClassifications) {
        this.onlyFollowingClassifications = onlyFollowingClassifications;
    }

    @Override
    public Map<String, Map<String, Object>>  getColumnProjection() {
        Map<String, Object> channelAttributes = new HashMap<>();
        channelAttributes.put(FIELD_SET_PARAM_NAME, this.classifications);
        channelAttributes.put(INCLUDE_SET_PARAM_NAME, this.onlyFollowingClassifications);
        channelComposition.getColumnProjection().put(OBJECT_ROOT_NODE_NAME, channelAttributes);

        return channelComposition.getColumnProjection();
    }
}
