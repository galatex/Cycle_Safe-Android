package io.galatexlabs.cyclesafe;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by jerem on 4/29/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Register submit button font change
        TextView rbsview=(TextView)findViewById(R.id.registersubmit_button);
        Typeface rbsface=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Bold.ttf");
        rbsview.setTypeface(rbsface);
    }
}
