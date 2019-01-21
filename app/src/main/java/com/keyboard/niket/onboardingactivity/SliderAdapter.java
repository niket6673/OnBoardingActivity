package com.keyboard.niket.onboardingactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] slider_images = {
            R.drawable.thumb_up_slider,
            R.drawable.comment_slider,
            R.drawable.share_slider,
            R.drawable.rocket
    };


    public String[] slider_headings = {
            "LIKE",
            "COMMENT",
            "SHARE",
            "LET'S GET STARTED!"
    };

    public String[] slider_details = {
            "You can like, only if you are logged in",
            "You can comment, only if you are logged in",
            "You can share, only if you are logged in",
            ""
    };


    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);


        ImageView imageView = view.findViewById(R.id.image);
        TextView heading = view.findViewById(R.id.heading);
        TextView details = view.findViewById(R.id.details);

        imageView.setImageResource(slider_images[position]);
        heading.setText(slider_headings[position]);
        details.setText(slider_details[position]);


        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
