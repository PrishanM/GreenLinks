package com.evensel.greenlinks.notifications;

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
 * Used for Listview in Notifications
 */
class NotificationsAdapter extends BaseAdapter{

    private final Context con;
    private HashMap<Integer,ArrayList<String>> notificationList;

    public NotificationsAdapter(Context context, HashMap<Integer,ArrayList<String>> notificationList){
        this.con = context;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
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
            convertView = mInflater.inflate(R.layout.notification_list_row, parent,false);
        }

        final TextView txtFRow = (TextView)convertView.findViewById(R.id.txtFirstRow);
        final TextView txtFrom = (TextView)convertView.findViewById(R.id.txtFrom);
        final TextView txtTo = (TextView)convertView.findViewById(R.id.txtTo);
        final TextView txtPre = (TextView)convertView.findViewById(R.id.txtPrevStatus);
        final TextView txtCurr = (TextView)convertView.findViewById(R.id.txtCurrStatus);
        final View isRead = (View)convertView.findViewById(R.id.isRead);

        if(notificationList.get(position).get(0).equalsIgnoreCase("Read")){
            isRead.setVisibility(View.GONE);
        }else{
            isRead.setVisibility(View.VISIBLE);
        }

        if(notificationList.get(position).get(1).equalsIgnoreCase("Cancelled")){
            txtFRow.setVisibility(View.GONE);
            txtTo.setVisibility(View.GONE);
            txtFrom.setText(notificationList.get(position).get(3));
        }else{
            txtFRow.setText(notificationList.get(position).get(3));
            txtPre.setText(notificationList.get(position).get(2));

            if(notificationList.get(position).get(2).equalsIgnoreCase("Now")){
                txtPre.setBackgroundColor(con.getResources().getColor(R.color.colorRed));
            }else if(notificationList.get(position).get(2).equalsIgnoreCase("Updated")){
                txtPre.setBackgroundColor(con.getResources().getColor(R.color.colorOrange));
            }else if(notificationList.get(position).get(2).equalsIgnoreCase("Confirmed")){
                txtPre.setBackgroundColor(con.getResources().getColor(R.color.colorGreen));
            }else if(notificationList.get(position).get(2).equalsIgnoreCase("Picked up")){
                txtPre.setBackgroundColor(con.getResources().getColor(R.color.colorBlue));
            }

            txtCurr.setText(notificationList.get(position).get(1));

            if(notificationList.get(position).get(1).equalsIgnoreCase("Now")){
                txtCurr.setBackgroundColor(con.getResources().getColor(R.color.colorRed));
            }else if(notificationList.get(position).get(1).equalsIgnoreCase("Updated")){
                txtCurr.setBackgroundColor(con.getResources().getColor(R.color.colorOrange));
            }else if(notificationList.get(position).get(1).equalsIgnoreCase("Confirmed")){
                txtCurr.setBackgroundColor(con.getResources().getColor(R.color.colorGreen));
            }else if(notificationList.get(position).get(1).equalsIgnoreCase("Picked up")){
                txtCurr.setBackgroundColor(con.getResources().getColor(R.color.colorBlue));
            }
        }

        return convertView;
    }
}
