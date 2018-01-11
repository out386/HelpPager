package gh.out386.helppager.models;

import java.util.ArrayList;

/**
 * Holds the data for a particular section (ViewPager tab). Use the builder to get an instance.
 */
public class HelpSectionItem {

    private ArrayList<HelpItem> helpItems;
    private String title;

    private HelpSectionItem(Builder builder) {
        helpItems = builder.helpItems;
        title = builder.title;
        builder.reset();
    }

    public ArrayList<HelpItem> getItems() {
        return helpItems;
    }

    /**
     * @return The title to show on the ViewPager tab.
     */
    public String getTitle() {
        return title;
    }

    public static class Builder {

        private ArrayList<HelpItem> helpItems = new ArrayList<>();
        private String title;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder addItem(HelpItem item) {
            this.helpItems.add(item);
            return this;
        }

        private void reset() {
            helpItems = new ArrayList<>();
        }

        public HelpSectionItem build() {
            return new HelpSectionItem(this);
        }
    }
}
