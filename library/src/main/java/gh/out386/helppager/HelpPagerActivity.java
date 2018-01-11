package gh.out386.helppager;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import gh.out386.helppager.models.HelpSectionItemsList;

public abstract class HelpPagerActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    private HelpSectionItemsList sectionItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_pager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.hpg_help_title);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        sectionItemsList = getHelpSectionItems();
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container);
        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method has to be overridden. Do not perform long-running operations here.
     *
     * @return The HelpSectionItemsList to use for the HelpPager.
     */
    protected abstract HelpSectionItemsList getHelpSectionItems();

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return HelpPagerFragment.newInstance(
                    sectionItemsList.getSections().get(position).getItems()
            );
        }

        @Override
        public int getCount() {
            return sectionItemsList.getSections().size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return sectionItemsList.getSections().get(position).getTitle();
        }
    }
}
