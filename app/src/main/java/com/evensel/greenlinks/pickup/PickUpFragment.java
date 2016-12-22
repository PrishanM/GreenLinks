package com.evensel.greenlinks.pickup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.utils.PagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

/**
 * Created by Prishan Maduka on 12/10/2016.
 */
public class PickUpFragment extends Fragment {

    private ViewPager mViewPager = null;
    private CirclePageIndicator circlePageIndicator = null;
    private PagerAdapter pagerAdapter;

    private List<Fragment> fList = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pickup, container, false);
        setHasOptionsMenu(true);

        initUI(rootView);

        return rootView;
    }

    //Initialize UI components
    private void initUI(View rootView) {

        /*mViewPager = (ViewPager)rootView.findViewById(R.id.pickupViewPager);
        circlePageIndicator = (CirclePageIndicator)rootView.findViewById(R.id.indicator);*/

        //setViewPagerFragments();

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_pagination_layout, new PickUpStepOneFragment());
        fragmentTransaction.commit();
    }
}
