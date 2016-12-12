package com.evensel.greenlinks.order;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evensel.greenlinks.R;

/**
 * Created by Prishan Maduka on 12/11/2016.
 */
public class ActiveOrderListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pickup_step_1, container, false);
        return rootView;
    }
}
