package com.evensel.greenlinks.pickup;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.utils.DatePickerCustom;
import com.evensel.greenlinks.utils.TimePickerCustom;

import java.util.Calendar;

/**
 * Created by Prishan Maduka on 12/11/2016.
 */
public class PickUpStepThreeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layoutDate,layoutTime;
    private TextView textDate,textTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pickup_step_3, container, false);

        initialize(rootView);

        return rootView;
    }

    private void initialize(View rootView) {
        layoutDate = (LinearLayout)rootView.findViewById(R.id.layoutDate);
        layoutTime = (LinearLayout)rootView.findViewById(R.id.layoutTime);

        textDate = (TextView)rootView.findViewById(R.id.txtDate);
        textTime = (TextView)rootView.findViewById(R.id.txtTime);

        layoutDate.setOnClickListener(this);
        layoutTime.setOnClickListener(this);
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
        date.setCallBack(regDateListener);
        date.show(getChildFragmentManager(), "Date Picker");
    }

    private void showTimePicker() {
        TimePickerCustom time = new TimePickerCustom();
        /**
         * Set Up Current Time Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("HOUR_OF_DAY", calender.get(Calendar.HOUR_OF_DAY));
        args.putInt("MINUTE", calender.get(Calendar.MINUTE));
        time.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        time.setCallBack(regTimeListener);
        time.show(getChildFragmentManager(), "Time Picker");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.layoutDate){
            showDatePicker();
        }else if(v.getId()==R.id.layoutTime){
            showTimePicker();
        }
    }

    private final DatePickerDialog.OnDateSetListener regDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            textDate.setTextColor(getResources().getColor(R.color.colorTextPrimary));
            textDate.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);

        }
    };

    private final TimePickerDialog.OnTimeSetListener regTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            textTime.setTextColor(getResources().getColor(R.color.colorTextPrimary));
            textTime.setText(hourOfDay+":"+minute);
        }
    };
}
