package io.galatexlabs.cyclesafe;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import helper.SQLiteHandler;
import helper.SessionManager;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;
    
    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
