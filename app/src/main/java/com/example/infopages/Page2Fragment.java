package com.example.infopages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager2.widget.ViewPager2;
import android.widget.ImageView;

public class Page2Fragment extends Fragment {

    private ViewPager2 viewPager;
    private ImageView leftArrow, rightArrow;
    private int[] images = {R.drawable.page2, R.drawable.page2_2, R.drawable.page2_4, R.drawable.page2_3};

    public Page2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        leftArrow = view.findViewById(R.id.leftArrow);
        rightArrow = view.findViewById(R.id.rightArrow);

        ImageSliderAdapter adapter = new ImageSliderAdapter(requireContext(), images);
        viewPager.setAdapter(adapter);

        leftArrow.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem > 0) {
                viewPager.setCurrentItem(currentItem - 1);
            }
        });

        rightArrow.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem < images.length - 1) {
                viewPager.setCurrentItem(currentItem + 1);
            }
        });

        return view;
    }
}
