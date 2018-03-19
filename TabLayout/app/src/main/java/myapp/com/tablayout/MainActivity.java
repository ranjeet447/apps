package myapp.com.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());

        customPagerAdapter.addFragment(new BlankFragment(),"All Topics");
        customPagerAdapter.addFragment(new BlankFragment(),"Popular Topics");

        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class CustomPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> mFragment = new ArrayList<>();
        ArrayList<String> mString = new ArrayList<>();


        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public  void addFragment(Fragment fragment, String title){
            mFragment.add(fragment);
            mString.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mString.get(position);
        }
    }
}
