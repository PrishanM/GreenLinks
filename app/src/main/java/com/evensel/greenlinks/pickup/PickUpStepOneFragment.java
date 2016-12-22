package com.evensel.greenlinks.pickup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.evensel.greenlinks.R;

/**
 * Created by Prishan Maduka on 12/11/2016.
 */
public class PickUpStepOneFragment extends Fragment implements View.OnClickListener {

    private boolean isMobileDevice,isComputers,isHome,isHybrid,isCatalytic = false;
    private TextView txtMobileDevice,txtComputers,txtHome,txtHybrid,txtCatalytic;
    private ImageView imgMobileDevice,imgComputers,imgHome,imgHybrid,imgCatalytic;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pickup_step_1, container, false);


        Button b1 = (Button)rootView.findViewById(R.id.btnNext);
        b1.setOnClickListener(this);

        initialize(rootView);

        return rootView;
    }

    private void initialize(View rootView) {
        txtMobileDevice = (TextView)rootView.findViewById(R.id.imgMobileDevices);
        txtComputers = (TextView)rootView.findViewById(R.id.imgComputers);
        txtHome = (TextView)rootView.findViewById(R.id.imgHomeAppliences);
        txtHybrid = (TextView)rootView.findViewById(R.id.imgHybridBatteries);
        txtCatalytic = (TextView)rootView.findViewById(R.id.imgCatalytic);

        imgMobileDevice = (ImageView) rootView.findViewById(R.id.imgMobileCheck);
        imgComputers = (ImageView)rootView.findViewById(R.id.imgComputerCheck);
        imgHome = (ImageView)rootView.findViewById(R.id.imgHomeAppCheck);
        imgHybrid = (ImageView)rootView.findViewById(R.id.imgHybridCheck);
        imgCatalytic = (ImageView)rootView.findViewById(R.id.imgCatalyticCheck);

        txtMobileDevice.setOnClickListener(this);
        txtComputers.setOnClickListener(this);
        txtHome.setOnClickListener(this);
        txtHybrid.setOnClickListener(this);
        txtCatalytic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imgMobileDevices){
            if(isMobileDevice){
                isMobileDevice = false;
                imgMobileDevice.setVisibility(View.GONE);
            }else{
                isMobileDevice = true;
                imgMobileDevice.setVisibility(View.VISIBLE);
            }
        }else if(v.getId()==R.id.imgComputers){
            if(isComputers){
                isComputers = false;
                imgComputers.setVisibility(View.GONE);
            }else{
                isComputers = true;
                imgComputers.setVisibility(View.VISIBLE);
            }
        }else if(v.getId()==R.id.imgHomeAppliences){
            if(isHome){
                isHome = false;
                imgHome.setVisibility(View.GONE);
            }else{
                isHome = true;
                imgHome.setVisibility(View.VISIBLE);
            }
        }else if(v.getId()==R.id.imgHybridBatteries){
            if(isHybrid){
                isHybrid = false;
                imgHybrid.setVisibility(View.GONE);
            }else{
                isHybrid = true;
                imgHybrid.setVisibility(View.VISIBLE);
            }
        }else if(v.getId()==R.id.imgCatalytic){
            if(isCatalytic){
                isCatalytic = false;
                imgCatalytic.setVisibility(View.GONE);
            }else{
                isCatalytic = true;
                imgCatalytic.setVisibility(View.VISIBLE);
            }
        }else if(v.getId()==R.id.btnNext){
            FragmentManager fragmentManager = getParentFragment().getChildFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(new PickUpStepOneFragment());
            fragmentTransaction.replace(R.id.home_pagination_layout, new PickUpStepTwoFragment());
            fragmentTransaction.commit();
        }

    }
}
