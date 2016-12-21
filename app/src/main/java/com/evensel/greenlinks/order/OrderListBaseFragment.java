package com.evensel.greenlinks.order;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.model.Order;
import com.evensel.greenlinks.utils.AppController;
import com.evensel.greenlinks.utils.DatePickerCustom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Prishan Maduka on 12/10/2016.
 */
public class OrderListBaseFragment extends Fragment implements View.OnClickListener {

    private ListView listView;
    private ImageView imgFilter;
    private TextView fromDate,toDate;
    private OrderListAdapter orderListAdapter;
    private Context context;
    private List<Order> orders;
    private boolean isFromDate = false;

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
        orders = new ArrayList<>();

        imgFilter = (ImageView)rootView.findViewById(R.id.imgFilter);
        fromDate = (TextView)rootView.findViewById(R.id.txtFromDate);
        toDate = (TextView)rootView.findViewById(R.id.txtToDate);

        listView = (ListView)rootView.findViewById(R.id.listOrderList);
        orderListAdapter = new OrderListAdapter(context,orders);
        listView.setAdapter(orderListAdapter);

        fromDate.setOnClickListener(this);
        toDate.setOnClickListener(this);
        imgFilter.setOnClickListener(this);

        setupFragment();

    }

    private void setupFragment(){

        orders.clear();

        Order arr1 = new Order();
        arr1.setCategory("Home Appliances");
        arr1.setPickupDate("12/12/2016");
        arr1.setOrderNumber("NO12GH1");
        arr1.setOrderStatus("Now");

        Order arr2 = new Order();
        arr2.setCategory("Computers");
        arr2.setPickupDate("01/12/2016");
        arr2.setOrderNumber("NO12GH1");
        arr2.setOrderStatus("Updated");


        Order arr3 = new Order();
        arr3.setCategory("Hybrid Batteries");
        arr3.setPickupDate("13/12/2016");
        arr3.setOrderNumber("NO12GH1");
        arr3.setOrderStatus("Confirmed");


        Order arr4 = new Order();
        arr4.setCategory("Mobile Devices");
        arr4.setPickupDate("19/12/2016");
        arr4.setOrderNumber("NO12GH1");
        arr4.setOrderStatus("Updated");


        Order arr5 = new Order();
        arr5.setCategory("Computers");
        arr5.setPickupDate("11/12/2016");
        arr5.setOrderNumber("NO12GH1");
        arr5.setOrderStatus("Picked up");


        Order arr6 = new Order();
        arr6.setCategory("Hybrid Batteries");
        arr6.setPickupDate("12/11/2016");
        arr6.setOrderNumber("NO12GH1");
        arr6.setOrderStatus("Picked up");

        orders.add(arr1);
        orders.add(arr2);
        orders.add(arr3);
        orders.add(arr4);
        orders.add(arr5);
        orders.add(arr6);

        orderListAdapter.notifyDataSetChanged();

        AppController.setOrders(orders);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.txtFromDate){
            isFromDate = true;
            showDatePicker();
        }else if(v.getId()==R.id.txtToDate){
            isFromDate = false;
            showDatePicker();
        }else if(v.getId()==R.id.imgFilter){
            compareDates(fromDate.getText().toString(),toDate.getText().toString());
        }
    }


    private void showDatePicker() {
        DatePickerCustom date = new DatePickerCustom();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("YEAR", calender.get(Calendar.YEAR));
        args.putInt("MONTH", calender.get(Calendar.MONTH));
        args.putInt("DAY", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */

        date.setCallBack(dateListener);
        date.show(getChildFragmentManager(), "Date Picker");
    }

    private final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            if(isFromDate){
                fromDate.setTextColor(getResources().getColor(R.color.colorTextPrimary));
                fromDate.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }else{
                toDate.setTextColor(getResources().getColor(R.color.colorTextPrimary));
                toDate.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }


        }
    };

    private void compareDates(String fromDate, String toDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Order> filteredList = new ArrayList<>();

        try {
            Date fDate = dateFormat.parse(fromDate);
            Date tDate = dateFormat.parse(toDate);


            Log.d("FROM : ",dateFormat.format(fDate));
            Log.d("TO : ",dateFormat.format(tDate));

            for(int i=0;i<orders.size();i++){
                try {
                    Date selectedDate = dateFormat.parse(orders.get(i).getPickupDate());

                    Log.d("SELECTED : ",dateFormat.format(selectedDate));

                    Log.d("ToCompare : ",selectedDate.compareTo(tDate)+"");
                    Log.d("FromCompare : ",selectedDate.compareTo(fDate)+"");
                    if(selectedDate.compareTo(fDate) * selectedDate.compareTo(tDate)<=0){
                        filteredList.add(orders.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            listView.setAdapter(new OrderListAdapter(context,filteredList));
        }catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
