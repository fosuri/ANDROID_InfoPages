package com.example.infopages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.infopages.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        replaceFragment(new Page1Fragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.page1:
                    replaceFragment(new Page1Fragment());
                    break;
                case R.id.page2:
                    replaceFragment(new Page2Fragment());
                    break;
                case R.id.page3:
                    replaceFragment(new Page3Fragment());
                    break;
                case R.id.page4:
                    replaceFragment(new Page4Fragment());
                    break;
                case R.id.page5:
                    replaceFragment(new Page5Fragment());
                    break;

            }


            return true;

        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}