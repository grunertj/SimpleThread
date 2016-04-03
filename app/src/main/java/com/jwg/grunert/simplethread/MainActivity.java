package com.jwg.grunert.simplethread;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    String global_fragments[];
    ViewPager viewPager;
    TabLayout tabLayout;

    MainFragment mainFragment = null;
    FirstFragment firstFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Possible work around for market launches. See http://code.google.com/p/android/issues/detail?id=2373
        // for more details. Essentially, the market launches the main activity on top of other activities.
        // we never want this to happen. Instead, we check if we are the root and if not, we finish.
        /*
        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) &&
                intentAction != null && intentAction.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
        */
        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }

        if (firstFragment == null) {
            firstFragment = new FirstFragment();
        }

        global_fragments = new String[2];
        global_fragments[0] = "Main";
        global_fragments[1] = "First";

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));
        viewPager.setOffscreenPageLimit(100);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private String fragments [] = global_fragments;

        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        public CustomAdapter(FragmentManager fm, Context applicationContext) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return mainFragment;
                case 1:
                    return firstFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }
}
