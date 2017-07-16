package com.app.sample.social;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sample.social.data.Tools;
import com.app.sample.social.model.Login;
import com.app.sample.social.presenter_login.LoginUserContract;
import com.app.sample.social.presenter_login.LoginUserPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ActivityLogin extends AppCompatActivity implements LoginUserContract.HomeViewLoginUsers {

    private static final int REQUEST_CAMERA_RESULT = 1;

    private EditText inputEmail, inputPassword;
    private TextView txt_register;
    private Button btnLogin;
    private ProgressBar progressBar;
    private View parent_view;

    LoginUserContract.HomePresenterLogoinUser presenter;

    String strLongNumber;

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);
        parent_view = findViewById(android.R.id.content);
        txt_register = (TextView) findViewById(R.id.txt_register);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_RESULT);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.getBoolean("isLogin", false) == true) {
            Intent i = new Intent(getApplicationContext(), ActivityMain.class);
            startActivity(i);
            finish();
        } else {

        }

        presenter = new LoginUserPresenter(this);


//        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
//        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        // for system bar in lollipop
        Tools.systemBarLolipop(this);

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), WebRegisterActivity.class);
                startActivity(i);
            }
        });
    }


    private void submitForm() {

        long number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
        strLongNumber = Long.toString(number);

        presenter.loginUser(inputEmail.getText().toString(), inputPassword.getText().toString(), strLongNumber);
    }


    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            //  inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else if (inputPassword.getText().length() < 5) {
            //  inputLayoutPassword.setError(getString(R.string.inv_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            // inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void loginUser(List<Login> login) {
        Log.e("api_status", login.get(0).getApi_status() + "");
        Log.e("api_text", login.get(0).getApi_text() + "");
        if (login.get(0).getApi_status().equals("200")) {

            String userId = login.get(0).getUser_id();
            Log.e("timeStamp2", strLongNumber);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("isLogin", true);
            editor.putString("userName", inputEmail.getText().toString());
            editor.putString("timeStamp", strLongNumber);
            editor.putString("userId", userId);
            editor.commit();

            Toast.makeText(getApplicationContext(), "ยินดีตอนรับ", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), ActivityMain.class);
            startActivity(i);
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "ล้มเหลว", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA_RESULT:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }


}

