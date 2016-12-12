package com.evensel.greenlinks.pickup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evensel.greenlinks.R;

/**
 * Created by Prishan Maduka on 12/11/2016.
 */
public class PickUpStepOneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pickup_step_1, container, false);
        Button b1 = (Button)rootView.findViewById(R.id.btnNext);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragment().getChildFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(new PickUpStepOneFragment());
                fragmentTransaction.replace(R.id.home_pagination_layout, new PickUpStepTwoFragment());
                fragmentTransaction.commit();
            }
        });



        return rootView;
    }
}
