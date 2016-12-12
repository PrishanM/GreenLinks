package com.evensel.greenlinks.order;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evensel.greenlinks.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Prishanm
 * Used for Listview in Order List
 */
class OrderListAdapter extends BaseAdapter{

    private final Context con;
    private HashMap<Integer,ArrayList<String>> ordersList;

    public OrderListAdapter(Context context, HashMap<Integer,ArrayList<String>> orderList){
        this.con = context;
        this.ordersList = orderList;
    }

    @Override
    public int getCount() {
        return ordersList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = null;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) con
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.order_list_row, parent,false);
        }

        final TextView txtDate = (TextView)convertView.findViewById(R.id.txtDate);
        final TextView txtCategory = (TextView)convertView.findViewById(R.id.txtCategory);
        final TextView txtStatus = (TextView)convertView.findViewById(R.id.txtStatus);
        final TextView txtOrder = (TextView)convertView.findViewById(R.id.txtOrderNo);

        txtDate.setText(ordersList.get(position).get(1));
        txtCategory.setText(ordersList.get(position).get(0));
        txtStatus.setText(ordersList.get(position).get(3));
        txtOrder.setText(ordersList.get(position).get(2));

        if(ordersList.get(position).get(3).equalsIgnoreCase("Now")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorRed));
        }else if(ordersList.get(position).get(3).equalsIgnoreCase("Updated")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorOrange));
        }else if(ordersList.get(position).get(3).equalsIgnoreCase("Confirmed")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorGreen));
        }else if(ordersList.get(position).get(3).equalsIgnoreCase("Picked up")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorBlue));
        }


        return convertView;
    }
}
