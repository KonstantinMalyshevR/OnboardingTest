package com.malyshev.onboardingtest.onboarding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.malyshev.onboardingtest.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.left_button)
    ImageButton leftButton;

    @BindView(R.id.right_button)
    ImageButton rightButton;

    @BindView(R.id.start_button)
    Button startButton;

    private OnboardingPagerAdapter adapter;
    private int pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        ButterKnife.bind(this);

        adapter = new OnboardingPagerAdapter(this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageNumber = position;

                if(pageNumber == 0) {
                    startButton.setVisibility(View.INVISIBLE);
                    leftButton.setVisibility(View.INVISIBLE);
                    rightButton.setVisibility(View.VISIBLE);
                } else if (pageNumber == adapter.getCount() - 1) {
                    startButton.setVisibility(View.VISIBLE);
                    leftButton.setVisibility(View.VISIBLE);
                    rightButton.setVisibility(View.INVISIBLE);
                } else {
                    startButton.setVisibility(View.INVISIBLE);
                    leftButton.setVisibility(View.VISIBLE);
                    rightButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(pageNumber);
    }

    @OnClick(R.id.left_button)
    public void leftButtonClick(View v) {
        viewPager.setCurrentItem(pageNumber - 1, true);
    }

    @OnClick(R.id.right_button)
    public void rightButtonClick(View v) {
        viewPager.setCurrentItem(pageNumber + 1, true);
    }

    @OnClick(R.id.close_button)
    public void closeButtonClick(View v) {
        OnboardingActivity.this.finish();
    }

    @OnClick(R.id.start_button)
    public void startButtonClick(View v) {
        OnboardingActivity.this.finish();
    }
}
