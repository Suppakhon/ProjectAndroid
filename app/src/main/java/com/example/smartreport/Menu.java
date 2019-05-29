package com.example.smartreport;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qrcode:
                Intent intQrcode = new Intent(this, Qrcode.class);
                startActivity(intQrcode);
                break;
            case R.id.add:
                Intent intAdddata = new Intent(this, Adddata.class);
                startActivity(intAdddata);
                break;
            case R.id.follow:
                Intent intFollow = new Intent(this, Follow.class);
                startActivity(intFollow);
                break;
            case R.id.point:
               // android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
               // builder.setMessage("ให้กำลังใจกับทีมผู้พัฒนา");

                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.custom_messbox);
               // dialog.setTitle("ให้กำลังใจทีมพัฒนา");
                dialog.show();
                break;
            case R.id.ok:
                final Dialog dialo = new Dialog(this);
                dialo.setContentView(R.layout.custom_messbox);
                dialo.cancel();
                showmessage("ขอบคุณสำหรับคำติชมครับ");

               // AlertDialog alertDialog = builder.create();
               // alertDialog.show();
                break;
            case R.id.logout:
                Intent intMainActivity = new Intent(this, MainActivity.class);
                startActivity(intMainActivity);
                showmessage("ออกจากระบบสำเร็จ");
        }
    }
    private void showmessage(String message) {
        Toast.makeText(getApplicationContext(),
                message,Toast.LENGTH_LONG).show();
    }
}
