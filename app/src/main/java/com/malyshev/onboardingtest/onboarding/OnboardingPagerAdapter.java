package com.malyshev.onboardingtest.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malyshev.onboardingtest.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingPagerAdapter extends PagerAdapter {

    private Context context;

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.text_view)
    TextView textView;

    private int[] texts = new int[]{
            R.string.text_tutorial_1,
            R.string.text_tutorial_2,
            R.string.text_tutorial_3,
            R.string.text_tutorial_4};

    private int[] pictures = new int[]{
            R.drawable.image_tutorial_1,
            R.drawable.image_tutorial_2,
            R.drawable.image_tutorial_3,
            R.drawable.image_tutorial_4};

    OnboardingPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.page_onboarding, container, false);

        ButterKnife.bind(this, itemView);

        imageView.setImageResource(pictures[position]);
        textView.setText(texts[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }

}