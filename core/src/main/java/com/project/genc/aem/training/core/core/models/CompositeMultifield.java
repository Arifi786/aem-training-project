package com.project.genc.aem.training.core.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CompositeMultifield{
    @Self
    private Resource resource;
    @ChildResource(name = "items")
    private List<Resource> items;
    private List<MultifieldItem> multifieldItems = new ArrayList<>();
    @PostConstruct
    protected void init() {
        if (items != null) {
            for (Resource item : items) {
                String text = item.getValueMap().get("text", String.class);
                String alt = item.getValueMap().get("alt", String.class);
                multifieldItems.add(new MultifieldItem(text, alt));
            }
        }
    }
    public List<MultifieldItem> getMultifieldItems() {
        return multifieldItems;
    }
    public static class MultifieldItem {
        private String text;
        private String alt;
        public MultifieldItem(String text, String alt) {
            this.text = text;
            this.alt = alt;
        }
        public String getText() {
            return text;
        }
        public String getAlt() {
            return alt;
        }
    }
}
 
