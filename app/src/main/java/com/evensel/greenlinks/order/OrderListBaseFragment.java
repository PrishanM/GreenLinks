package com.evensel.greenlinks.order;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.evensel.greenlinks.R;

/**
 * Created by Prishan Maduka on 12/10/2016.
 */
public class OrderListBaseFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layoutActive,layoutHistory;
    private View viewActive,viewHistory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order_list, container, false);
        setHasOptionsMenu(true);

        initUI(rootView);

        return rootView;
    }

    //Initialize UI components
    private void initUI(View rootView) {

        layoutActive = (LinearLayout)rootView.findViewById(R.id.layoutActive);
        layoutHistory = (LinearLayout)rootView.findViewById(R.id.layoutHistory);

        viewActive = (View)rootView.findViewById(R.id.viewActive);
        viewHistory = (View)rootView.findViewById(R.id.viewHistory);

        setupFragment(new ActiveOrderListFragment());
        viewActive.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        viewHistory.setBackgroundColor(Color.TRANSPARENT);

        layoutActive.setOnClickListener(this);
        layoutHistory.setOnClickListener(this);

    }

    private void setupFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_pagination_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.layoutActive){
            setupFragment(new ActiveOrderListFragment());
            viewActive.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            viewHistory.setBackgroundColor(Color.TRANSPARENT);
        }else if(v.getId()==R.id.layoutHistory){
            setupFragment(new HistoryOrderListFragment());
            viewHistory.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            viewActive.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
