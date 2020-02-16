package com.malyshev.onboardingtest;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.malyshev.onboardingtest.onboarding.OnboardingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startActivity(new Intent(MainActivity.this, OnboardingActivity.class));
    }

    @OnClick(R.id.button)
    public void startOnboarding(View v) {
        startActivity(new Intent(MainActivity.this, OnboardingActivity.class));
    }

}
