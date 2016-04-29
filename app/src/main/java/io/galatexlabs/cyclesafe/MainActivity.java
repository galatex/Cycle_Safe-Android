package io.galatexlabs.cyclesafe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    /** Called when the user clicks the Send button */
    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}
