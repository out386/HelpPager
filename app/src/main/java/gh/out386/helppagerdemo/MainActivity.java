package gh.out386.helppagerdemo;

import gh.out386.helppager.HelpPagerActivity;
import gh.out386.helppager.models.HelpItem;
import gh.out386.helppager.models.HelpSectionItem;
import gh.out386.helppager.models.HelpSectionItemsList;

public class MainActivity extends HelpPagerActivity {

    @Override
    protected HelpSectionItemsList getHelpSectionItems() {
        // Put all your data in arrays.xml (or in any other xml, inside an array)
        // Small data sets can just be set directly from Strings.
        String[] sectionNames = getResources().getStringArray(R.array.help_sections);
        String[] s1_names = getResources().getStringArray(R.array.s1_names);
        String[] s2_names = getResources().getStringArray(R.array.s2_names);
        String[] s3_names = getResources().getStringArray(R.array.s3_names);
        String[] s1_texts = getResources().getStringArray(R.array.s1_texts);
        String[] s2_texts = getResources().getStringArray(R.array.s2_texts);
        String[] s3_texts = getResources().getStringArray(R.array.s3_texts);
        HelpSectionItemsList.Builder helpSectionBuilder = new HelpSectionItemsList.Builder();

        for (int sections = 0; sections < sectionNames.length; sections++) {
            int itemsLength;
            String[] names;
            String[] texts;
            HelpSectionItem.Builder itemBuilder = new HelpSectionItem.Builder();
            switch (sections) {
                case 0:
                    names = s1_names;
                    texts = s1_texts;
                    break;
                case 1:
                    names = s2_names;
                    texts = s2_texts;
                    break;
                case 2:
                    names = s3_names;
                    texts = s3_texts;
                    break;
                default:
                    continue;
            }
            // In case one of the arrays are shorter, by accident
            itemsLength = Math.min(names.length, texts.length);
            for (int j = 0; j < itemsLength; j++) {
                itemBuilder.addItem(
                        new HelpItem.Builder()
                                .withName(names[j])
                                .withText(texts[j])
                                .build()
                );
            }
            itemBuilder.withTitle(sectionNames[sections]);
            helpSectionBuilder.addSection(itemBuilder.build());
        }
        return helpSectionBuilder.build();
    }

}
