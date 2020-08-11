package example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import example.domain.Attribute;
import example.domain.Channel;
import example.domain.Classification;
import example.domain.Products;
import example.domain.decorator.ChannelAttributes;
import example.domain.decorator.ChannelClassification;
import example.domain.decorator.ChannelComposition;
import example.domain.decorator.ChannelProducts;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Demo fields (for testing purposes)
    private static final List<Attribute> attributes = new ArrayList<>();
    private static final List<Classification> classification = new ArrayList<>();
    private static final List<Products> products = new ArrayList<>();

    // Populate demo fields with data
    static {
        attributes.add(new Attribute("1", "First"));
        attributes.add(new Attribute("2", "Second"));

        classification.add(new Classification("1", "First"));
        classification.add(new Classification("2", "Second"));

        products.add(new Products("Food", 100));
        products.add(new Products("Socks", 5));
    }

    public static void main(String[] args) throws JsonProcessingException {

        // Create Channel Instance
        ChannelComposition channel = new Channel();
        channel.setChannelId("1");
        channel.setDescription("Demo channel");

        // Wrap Channel with ChannelAttributes to expand Channel with new data.
        channel = new ChannelAttributes(channel, attributes, false);

        // Example of usage own methods of ChannelAttributes instance. So it's flexible.
        ((ChannelAttributes) channel).getAttributes().add(new Attribute("added", "added attribute"));
        ((ChannelAttributes) channel).setOnlyFollowingAttributes(true);

        // Wrap Channel with ChannelClassification.
        channel = new ChannelClassification(channel, classification, true);
        ((ChannelClassification) channel).setOnlyFollowingClassifications(false);

        channel = new ChannelProducts(channel, products, true);

        // Print data as a JSON to overview Nodes structure.
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(channel);
        System.out.println(json);
    }
}
