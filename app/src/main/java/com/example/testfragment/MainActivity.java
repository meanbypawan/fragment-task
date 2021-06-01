package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.testfragment.databinding.HomeBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    // home.xml
    HomeBinding binding;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(LayoutInflater.from(MainActivity.this));
        setContentView(binding.getRoot());
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("STUDENT"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("BATCH"));
        manager = getSupportFragmentManager();
        binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String title = tab.getText().toString();
                if(title.equalsIgnoreCase("BATCH")){
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.ll,new BatchListFragment());
                    transaction.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}