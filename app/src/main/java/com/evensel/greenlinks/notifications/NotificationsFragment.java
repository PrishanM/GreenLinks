package com.evensel.greenlinks.notifications;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layoutActive,layoutHistory;
    private View viewActive,viewHistory;
    private ListView listView;
    private Context context;
    private HashMap<Integer,ArrayList<String >> notifications;
    private NotificationsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        setHasOptionsMenu(true);

        initUI(rootView);

        return rootView;
    }

    //Initialize UI components
    private void initUI(View rootView) {

        context = getActivity();
        notifications = new HashMap<>();

        listView = (ListView)rootView.findViewById(R.id.listNotifications);
        adapter = new NotificationsAdapter(context,notifications);
        listView.setAdapter(adapter);

        setupFragment();

    }

    private void setupFragment(){

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("No");
        arr1.add("Updated");
        arr1.add("Now");
        arr1.add("Order No.5672345 on 11/11/2016 has changed its status");

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Read");
        arr2.add("Confirmed");
        arr2.add("Updated");
        arr2.add("Order No.56723 on 11/11/2016 has changed its status");

        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("No");
        arr3.add("Picked up");
        arr3.add("Confirmed");
        arr3.add("Order No.56723E1 on 11/11/2016 has changed its status");

        ArrayList<String> arr4 = new ArrayList<>();
        arr4.add("No");
        arr4.add("Cancelled");
        arr4.add("Now");
        arr4.add("Order No.5672345 on 11/11/2016 got cancelled. Call our hotline 0112334455 to find out more");


        notifications.clear();
        notifications.put(0,arr1);
        notifications.put(1,arr2);
        notifications.put(2,arr3);
        notifications.put(3,arr4);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {

    }

}
