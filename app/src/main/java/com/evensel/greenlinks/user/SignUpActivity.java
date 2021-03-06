package com.evensel.greenlinks.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evensel.greenlinks.R;

/**
 * Created by Prishan Maduka on 12/4/2016.
 */
public class SignUpActivity extends AppCompatActivity {

    private EditText name,email,password,conPassword,contactNumber;
    private Button btnSignUp;
    private ProgressDialog progressDialog;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setActionBar();
        initialize();
    }

    //Initialize UI components
    private void initialize() {
        context = this;

        name = (EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPassword);
        conPassword = (EditText)findViewById(R.id.edtConfirmPassword);
        contactNumber = (EditText)findViewById(R.id.edtContactNumber);

        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,VerifyAccountActivity.class));
            }
        });
    }

    //Setup action bar
    private void setActionBar() {
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar_text, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText(getResources().getString(R.string.sign_up));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
    }
}
