package io.galatexlabs.cyclesafe;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import helper.SQLiteHandler;
import helper.SessionManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "debug";

    private Button btnLogout;
    private LoginButton loginButton;

    private SQLiteHandler db;
    private SessionManager session;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);


        loginButton = (LoginButton)findViewById(R.id.fbLoginButton);

        // CallbackManager for FB
        callbackManager = CallbackManager.Factory.create();


        btnLogout = (Button) findViewById(R.id.btnLogout);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        // Custom font functions //

        // Title button font change
        TextView tv=(TextView)findViewById(R.id.mainTitleTV);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Bold.ttf");
        tv.setTypeface(face);

        // Login button font change
        TextView lbview=(TextView)findViewById(R.id.login_button);
        Typeface lbface=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Bold.ttf");
        lbview.setTypeface(lbface);

        // Login button font change
        TextView rbview=(TextView)findViewById(R.id.register_button);
        Typeface rbface=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Bold.ttf");
        rbview.setTypeface(rbface);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException e) {
        }
    };

    /** Called when the user clicks the Register button */
    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
