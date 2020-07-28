package com.am.mymessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edmob,edmsg;
    String stmob,stmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edmob=findViewById(R.id.editTextTextPersonName);
        edmsg=findViewById(R.id.editTextTextPersonName2);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_EXTERNAL_STORAGE},1);
    }

    public void sedn(View view) {
        stmob=edmob.getText().toString();
        stmsg=edmsg.getText().toString();
        Toast.makeText(this, "number is "+stmob+"\n Msg is "+stmsg, Toast.LENGTH_SHORT).show();
        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(stmob,null,stmsg,null,null);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(MainActivity.this, "Permission allowed!!", Toast.LENGTH_SHORT).show();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.


                    //alert ==> will not work without permission => give or exit

                    finish();

                    Toast.makeText(MainActivity.this, "Permission denied to send sms", Toast.LENGTH_SHORT).show();
                }
                return;
            }


            // other 'case' lines to check for other
            // permissions this app might request

    }

