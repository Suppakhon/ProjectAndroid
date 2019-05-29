package com.example.smartreport;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Qrcode extends Activity implements View.OnClickListener {

    public static final int REQUEST_QR_SCAN = 4;
    TextView textContent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        textContent = (TextView) findViewById(R.id.textContent);

        Button buttonIntent = (Button) findViewById(R.id.buttonIntent);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent =
                        new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(Intent.createChooser(intent
                        , "Scan with"), REQUEST_QR_SCAN);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode
            , Intent intent) {
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents = intent.getStringExtra("SCAN_RESULT");
            textContent.setText(contents);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back1:
                Intent intMenu = new Intent(this, Menu.class);
                startActivity(intMenu);
                break;
        }
    }
}

