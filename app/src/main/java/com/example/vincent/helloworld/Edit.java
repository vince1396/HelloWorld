package com.example.vincent.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Edit extends Activity {

    private int img;
    private ImageView avatar;
    private EditText edit;

    //================= ON CREATE ==================
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        //================= DECLARATION VARIABLES ==================
        Button valider = (Button) findViewById(R.id.valider);
        Button img1 = (Button) findViewById(R.id.img1);
        Button img2 = (Button) findViewById(R.id.img2);
        avatar = (ImageView) findViewById(R.id.avatar);
        edit = (EditText) findViewById(R.id.edit);


        //========== DEFINITION HINT DE TEXTEDIT ===================
        edit.setHint(getString(R.string.mail));

        //================= CLICK SUR IMAGE 1 ======================
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar.setImageResource(R.drawable.android);
                img = R.drawable.android;
            }
        });

        //================= CLICK SUR IMAGE 2 ======================
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar.setImageResource(R.drawable.apple);
                img = R.drawable.apple;
            }
        });

        //================= CLICK SUR VALIDER ======================
        valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                String email = edit.getText().toString();

                Intent intent = new Intent(Edit.this, Infos.class);
                intent.putExtra("postemail", email);
                intent.putExtra("avatar", img);
                startActivity(intent);
            }
        });
    }
}
