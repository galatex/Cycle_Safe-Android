package io.galatexlabs.cyclesafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by jerem on 4/29/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
