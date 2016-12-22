package com.evensel.greenlinks.order;

/*import android.app.DatePickerDialog;*/


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.evensel.greenlinks.R;
import com.evensel.greenlinks.model.Order;
import com.evensel.greenlinks.utils.AppController;

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
    private ImageView imgFilter,imgClear;
    private TextView dateRange;
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
        imgClear = (ImageView) rootView.findViewById(R.id.imgClear);
        dateRange = (TextView)rootView.findViewById(R.id.txtDateRange);

        listView = (ListView)rootView.findViewById(R.id.listOrderList);
        orderListAdapter = new OrderListAdapter(context,orders);
        listView.setAdapter(orderListAdapter);

        imgClear.setOnClickListener(this);
        imgFilter.setOnClickListener(this);

        setupFragment();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

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
        if(v.getId()==R.id.imgFilter){
            Calendar now = Calendar.getInstance();
            DatePickerDialog dpd = DatePickerDialog.newInstance(
                    dateSetListener,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );
            dpd.show(getFragmentManager(),"Datepickerdialog");
        }else if(v.getId()==R.id.imgClear){
            dateRange.setText("");
            listView.setAdapter(new OrderListAdapter(context,orders));
            AppController.setOrders(orders);

        }
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
            compareDates(dayOfMonth+"/"+(monthOfYear+1)+"/"+year,dayOfMonthEnd+"/"+(monthOfYearEnd+1)+"/"+yearEnd);
            dateRange.setText("From : "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year+"  To : "+dayOfMonthEnd+"/"+(monthOfYearEnd+1)+"/"+yearEnd);
        }
    };

    private void compareDates(String fromDate, String toDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Order> filteredList = new ArrayList<>();

        try {
            Date fDate = dateFormat.parse(fromDate);
            Date tDate = dateFormat.parse(toDate);
            for(int i=0;i<orders.size();i++){
                try {
                    Date selectedDate = dateFormat.parse(orders.get(i).getPickupDate());
                    if(selectedDate.compareTo(fDate) * selectedDate.compareTo(tDate)<=0){
                        filteredList.add(orders.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            listView.setAdapter(new OrderListAdapter(context,filteredList));
            AppController.setOrders(filteredList);
        }catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
