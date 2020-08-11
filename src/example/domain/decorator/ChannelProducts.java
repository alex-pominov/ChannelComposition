package example.domain.decorator;

import example.domain.Products;
import lombok.Getter;
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
public class ChannelProducts extends ColumnProjectionDecorator {

    private static final String OBJECT_ROOT_NODE_NAME = "channelProducts";
    private static final String FIELD_SET_PARAM_NAME = "products";
    private static final String INCLUDE_SET_PARAM_NAME = "onlyFollowing";

    Boolean onlyFollowingProducts = false;
    List<Products> products = new ArrayList<>();

    public ChannelProducts(ChannelComposition channelComposition, List<Products> products, Boolean onlyFollowingProducts) {
        super(channelComposition);
        this.onlyFollowingProducts = onlyFollowingProducts;
        this.products = products;
    }

    @Override
    public Map<String, Map<String, Object>>  getColumnProjection() {
        Map<String, Object> channelAttributes = new HashMap<>();
        channelAttributes.put(FIELD_SET_PARAM_NAME, this.products);
        channelAttributes.put(INCLUDE_SET_PARAM_NAME, this.onlyFollowingProducts);
        channelComposition.getColumnProjection().put(OBJECT_ROOT_NODE_NAME, channelAttributes);

        return channelComposition.getColumnProjection();
    }
}
