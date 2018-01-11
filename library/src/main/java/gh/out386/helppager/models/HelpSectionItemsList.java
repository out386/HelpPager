package gh.out386.helppager.models;

import java.util.ArrayList;

/**
 * Holds all the data that needs to be displayed. Use the builder to get an instance.
 */
public class HelpSectionItemsList {

    private ArrayList<HelpSectionItem> itemsList;

    private HelpSectionItemsList(Builder builder) {
        itemsList = builder.itemsList;
    }

    public ArrayList<HelpSectionItem> getSections() {
        return itemsList;
    }

    public static class Builder {

        private ArrayList<HelpSectionItem> itemsList = new ArrayList<>();

        /**
         * Add a section to the ViewPager. Each section has its own tab in the ViewPager, and contains items.
         *
         * @param item The section item.
         * @return This builder.
         */
        public Builder addSection(HelpSectionItem item) {
            this.itemsList.add(item);
            return this;
        }

        public HelpSectionItemsList build() {
            return new HelpSectionItemsList(this);
        }
    }
}
