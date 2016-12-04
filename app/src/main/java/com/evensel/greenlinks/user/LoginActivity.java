package com.evensel.greenlinks.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evensel.greenlinks.R;
import com.evensel.greenlinks.utils.Constatnts;
import com.evensel.greenlinks.utils.ValidatorUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Context context;

    private EditText userName,password;
    private Button btnLogin,btnSignUp;
    private TextView txtForgotPassword;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setActionBar();
        initialize();

    }

    //Initialize UI components
    private void initialize() {

        context = this;

        userName = (EditText)findViewById(R.id.edtUserName);
        password = (EditText)findViewById(R.id.edtPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        txtForgotPassword = (TextView)findViewById(R.id.txtForgotPassword);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        txtForgotPassword.setOnClickListener(this);

    }

    //Setup action bar
    private void setActionBar() {
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.action_bar_text, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.MATCH_PARENT,Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText(getResources().getString(R.string.login));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
    }


    @Override
    public void onClick(View v) {
        Drawable d= getResources().getDrawable(R.drawable.ic_action_error,null);
        d.setBounds(0, 0,d.getIntrinsicWidth(), d.getIntrinsicHeight());
        if(v.getId()==R.id.btnLogin){
            boolean isValidInput = true;

            if(ValidatorUtil.isEmptyText(userName.getText().toString())){
                isValidInput = false;
                userName.setError(getString(R.string.no_username),d);
            }else if(!ValidatorUtil.isValidEmailAddress(userName.getText().toString())){
                isValidInput = false;
                userName.setError(getString(R.string.invalid_username),d);
            }

            if(ValidatorUtil.isEmptyText(password.getText().toString())){
                isValidInput = false;
                password.setError(getString(R.string.empty_password),d);
            }else if(ValidatorUtil.isValidTextLength(password.getText().toString(), Constatnts.PASSWORD_LENGTH)){
                isValidInput = false;
                password.setError(getString(R.string.wrong_password_length),d);
            }

            if (isValidInput){
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(getString(R.string.user_authentication_message));
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(true);
            }
        }else if(v.getId()==R.id.btnSignUp){
            startActivity(new Intent(context,SignUpActivity.class));

        }else if(v.getId()==R.id.txtForgotPassword){

        }
    }
}
