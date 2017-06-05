package com.example.vincent.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Infos extends Activity {

    //================= ON CREATE ==================
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infos);

        //=========== DECLARATION VARIABLES ===========

        String email = getIntent().getStringExtra("postemail");
        int avatar = getIntent().getIntExtra("avatar", 0);


        TextView text = (TextView) findViewById(R.id.email);
        ImageView image = (ImageView) findViewById(R.id.avatar);


        //=========== SETTING XML ============
        text.setText(email);

        image.setImageResource(avatar);

    }
}
