package com.evensel.greenlinks.order;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.evensel.greenlinks.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Prishan Maduka on 12/10/2016.
 */
public class OrderListBaseFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layoutActive,layoutHistory;
    private View viewActive,viewHistory;
    private ListView listView;
    private OrderListAdapter orderListAdapter;
    private Context context;
    private HashMap<Integer,ArrayList<String >> orderList;

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

        context = getActivity();
        orderList = new HashMap<>();

        layoutActive = (LinearLayout)rootView.findViewById(R.id.layoutActive);
        layoutHistory = (LinearLayout)rootView.findViewById(R.id.layoutHistory);

        viewActive = (View)rootView.findViewById(R.id.viewActive);
        viewHistory = (View)rootView.findViewById(R.id.viewHistory);

        listView = (ListView)rootView.findViewById(R.id.listOrderList);
        orderListAdapter = new OrderListAdapter(context,orderList);
        listView.setAdapter(orderListAdapter);

        setupFragment();
        viewActive.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        viewHistory.setBackgroundColor(Color.TRANSPARENT);

        layoutActive.setOnClickListener(this);
        layoutHistory.setOnClickListener(this);

    }

    private void setupFragment(){

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("Home Appliances");
        arr1.add("12/12/2016");
        arr1.add("NO12GH1");
        arr1.add("Now");

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Computers");
        arr2.add("12/12/2016");
        arr2.add("NO12GH1");
        arr2.add("Updated");

        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("Hybrid Batteries");
        arr3.add("12/12/2016");
        arr3.add("NO12GH1");
        arr3.add("Confirmed");

        ArrayList<String> arr4 = new ArrayList<>();
        arr4.add("Mobile Devices");
        arr4.add("12/12/2016");
        arr4.add("NO12GH1");
        arr4.add("Updated");


        orderList.clear();
        orderList.put(0,arr1);
        orderList.put(1,arr2);
        orderList.put(2,arr3);
        orderList.put(3,arr4);
        orderList.put(4,arr1);
        orderList.put(7,arr2);
        orderList.put(6,arr3);
        orderList.put(5,arr4);

        orderListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.layoutActive){
            setupFragment();
            viewActive.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            viewHistory.setBackgroundColor(Color.TRANSPARENT);
        }else if(v.getId()==R.id.layoutHistory){
            setHistory();
            viewHistory.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            viewActive.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void setHistory(){
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("Home Appliances");
        arr1.add("12/12/2016");
        arr1.add("NO12GH1");
        arr1.add("Picked up");

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Computers");
        arr2.add("12/12/2016");
        arr2.add("NO12GH1");
        arr2.add("Picked up");

        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("Hybrid Batteries");
        arr3.add("12/12/2016");
        arr3.add("NO12GH1");
        arr3.add("Picked up");

        ArrayList<String> arr4 = new ArrayList<>();
        arr4.add("Mobile Devices");
        arr4.add("12/12/2016");
        arr4.add("NO12GH1");
        arr4.add("Picked up");


        orderList.clear();
        orderList.put(0,arr1);
        orderList.put(1,arr2);
        orderList.put(2,arr3);
        orderList.put(3,arr4);

        orderListAdapter.notifyDataSetChanged();
    }
}
