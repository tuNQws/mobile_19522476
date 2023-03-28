package com.example.phonecalling_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 1;

    EditText phoneNumberEdtxt;
    Button callBtn;

    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEdtxt = findViewById(R.id.phoneNumberEdtxt);
        phoneNumber = phoneNumberEdtxt.getText().toString();
        callBtn = findViewById(R.id.callBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            PERMISSIONS_REQUEST_CALL_PHONE);

                } else {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                phoneNumber = phoneNumberEdtxt.getText().toString();

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);

            } else {

                Toast.makeText(this, "Permission to make phone calls is required", Toast.LENGTH_SHORT).show();
            }
        }
    }
}