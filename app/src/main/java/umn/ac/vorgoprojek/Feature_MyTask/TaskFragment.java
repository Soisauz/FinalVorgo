package umn.ac.vorgoprojek.Feature_MyTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import umn.ac.vorgoprojek.Feature_MyTask.TabAdapter;
import umn.ac.vorgoprojek.Feature_MyTask.daily;
import umn.ac.vorgoprojek.Feature_MyTask.month;
import umn.ac.vorgoprojek.R;

public class TaskFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        ViewPager viewPager = view.findViewById(R.id.view_pager);


        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        return view;


    }

    private void setupViewPager(ViewPager viewPager){
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new daily(), "Daily");
        tabAdapter.addFragment(new month(), "Month");
        viewPager.setAdapter(tabAdapter);
    }




}
