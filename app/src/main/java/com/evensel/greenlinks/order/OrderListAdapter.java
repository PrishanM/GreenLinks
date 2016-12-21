package com.evensel.greenlinks.order;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.model.Order;

import java.util.List;

/**
 * @author Prishanm
 * Used for Listview in Order List
 */
class OrderListAdapter extends BaseAdapter{

    private final Context con;
    private List<Order> orders;

    public OrderListAdapter(Context context, List<Order> orderList){
        this.con = context;
        this.orders = orderList;
    }

    @Override
    public int getCount() {
        return orders.size();
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

        txtDate.setText(orders.get(position).getPickupDate());
        txtCategory.setText(orders.get(position).getCategory());
        txtStatus.setText(orders.get(position).getOrderStatus());
        txtOrder.setText(orders.get(position).getOrderNumber());

        if(orders.get(position).getOrderStatus().equalsIgnoreCase("Now")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorRed));
        }else if(orders.get(position).getOrderStatus().equalsIgnoreCase("Updated")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorOrange));
        }else if(orders.get(position).getOrderStatus().equalsIgnoreCase("Confirmed")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorGreen));
        }else if(orders.get(position).getOrderStatus().equalsIgnoreCase("Picked up")){
            txtStatus.setBackgroundColor(con.getResources().getColor(R.color.colorBlue));
        }


        return convertView;
    }
}
