package com.evensel.greenlinks.utils;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Prishan Maduka on 7/23/2016.
 */
public class TimePickerCustom extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener onTimeSet;

    public TimePickerCustom(){

    }

    public void setCallBack(TimePickerDialog.OnTimeSetListener onTime) {
        onTimeSet = onTime;
    }

    private int hour, minute;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        hour = args.getInt("HOUR_OF_DAY");
        minute = args.getInt("MINUTE");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), onTimeSet, hour, minute, true);
    }


}
