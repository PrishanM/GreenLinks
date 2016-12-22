package com.evensel.greenlinks.base;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.account.AccountFragment;
import com.evensel.greenlinks.notifications.NotificationsFragment;
import com.evensel.greenlinks.order.OrderListBaseFragment;
import com.evensel.greenlinks.pickup.PickUpFragment;

/*import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;*/

/**
 * Created by Prishan Maduka on 12/10/2016.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutRequest,layoutOrderList,layoutNotifications,layoutMyAccount;
    private TextView textviewTitle;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        setActionBar();
        initialize();
    }

    private void initialize() {
        context = this;

        layoutRequest = (LinearLayout)findViewById(R.id.layoutPickup);
        layoutOrderList = (LinearLayout)findViewById(R.id.layoutOrders);
        layoutNotifications = (LinearLayout)findViewById(R.id.layoutNotifications);
        layoutMyAccount = (LinearLayout)findViewById(R.id.layoutAccount);

        layoutRequest.setOnClickListener(this);
        layoutOrderList.setOnClickListener(this);
        layoutNotifications.setOnClickListener(this);
        layoutMyAccount.setOnClickListener(this);

        layoutRequest.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        layoutOrderList.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
        layoutNotifications.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
        layoutMyAccount.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
        textviewTitle.setText(getString(R.string.pickup_request));
        setFragment(new PickUpFragment());

    }

    //Setup action bar
    private void setActionBar() {
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar_text, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText(getString(R.string.pickup_request));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
    }

    private void setFragment(Fragment fragment) {
        /*Bundle data = new Bundle();
        data.putInt("JOBID", getIntent().getIntExtra("ID",0));
        fragment.setArguments(data);*/
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.baseFrame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.layoutPickup){
            layoutRequest.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            layoutOrderList.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutNotifications.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutMyAccount.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            textviewTitle.setText(getString(R.string.pickup_request));
            setFragment(new PickUpFragment());
        }else if(v.getId()==R.id.layoutOrders){
            layoutRequest.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutOrderList.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            layoutNotifications.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutMyAccount.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            textviewTitle.setText(getString(R.string.order_list));
            setFragment(new OrderListBaseFragment());
        }else if(v.getId()==R.id.layoutNotifications){
            layoutRequest.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutOrderList.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutNotifications.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            layoutMyAccount.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            textviewTitle.setText(getString(R.string.notifications));
            setFragment(new NotificationsFragment());
        }else if(v.getId()==R.id.layoutAccount){
            layoutRequest.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutOrderList.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutNotifications.setBackgroundColor(getResources().getColor(R.color.colorNotSelectedTab));
            layoutMyAccount.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            textviewTitle.setText(getString(R.string.my_account));
            setFragment(new AccountFragment());
        }
    }
}
