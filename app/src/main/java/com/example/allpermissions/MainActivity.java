package com.example.allpermissions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CAMERA = 1;
    private static final int PERMISSION_REQUEST_CONTACTS = 2;
    private static final int PERMISSION_REQUEST_LOCATION = 3;
    private static final int PERMISSION_REQUEST_MICROPHONE = 4;
    private static final int PERMISSION_REQUEST_STORAGE = 5;
    private static final int PERMISSION_REQUEST_SMS = 6;
    private static final int PERMISSION_REQUEST_PHONE = 7;
    private static final int PERMISSION_REQUEST_CALENDAR = 8;
    private static final int PERMISSION_REQUEST_BLUETOOTH = 9;
    private static final int PERMISSION_REQUEST_WIFI = 10;
    private static final int PERMISSION_REQUEST_SENSORS = 11;
    private static final int PERMISSION_REQUEST_NFC = 12;
    private static final int PERMISSION_REQUEST_INTERNET = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestCameraPermission(View view) {
        requestPermission(Manifest.permission.CAMERA, PERMISSION_REQUEST_CAMERA);
    }

    public void requestContactsPermission(View view) {
        requestPermission(Manifest.permission.READ_CONTACTS, PERMISSION_REQUEST_CONTACTS);
    }

    public void requestLocationPermission(View view) {
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, PERMISSION_REQUEST_LOCATION);
    }

    public void requestMicrophonePermission(View view) {
        requestPermission(Manifest.permission.RECORD_AUDIO, PERMISSION_REQUEST_MICROPHONE);
    }

    public void requestStoragePermission(View view) {
        // Check if the MANAGE_EXTERNAL_STORAGE permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted
            Toast.makeText(this, "Storage permission already granted", Toast.LENGTH_SHORT).show();
        } else {
            // Request the MANAGE_EXTERNAL_STORAGE permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.MANAGE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);
        }
    }

    public void requestSMSPermission(View view) {
        requestPermission(Manifest.permission.SEND_SMS, PERMISSION_REQUEST_SMS);
    }

    public void requestPhonePermission(View view) {
        requestPermission(Manifest.permission.CALL_PHONE, PERMISSION_REQUEST_PHONE);
    }

    public void requestCalendarPermission(View view) {
        requestPermission(Manifest.permission.READ_CALENDAR, PERMISSION_REQUEST_CALENDAR);
    }

    public void requestBluetoothPermission(View view) {
        requestPermission(Manifest.permission.BLUETOOTH, PERMISSION_REQUEST_BLUETOOTH);
    }

    public void requestWifiPermission(View view) {
        requestPermission(Manifest.permission.ACCESS_WIFI_STATE, PERMISSION_REQUEST_WIFI);
    }

    public void requestSensorPermission(View view) {
        requestPermission(Manifest.permission.BODY_SENSORS, PERMISSION_REQUEST_SENSORS);
    }

    public void requestNFCPermission(View view) {
        requestPermission(Manifest.permission.NFC, PERMISSION_REQUEST_NFC);
    }

    public void requestInternetPermission(View view) {
        requestPermission(Manifest.permission.INTERNET, PERMISSION_REQUEST_INTERNET);
    }

    private void requestPermission(String permission, int requestCode) {
        if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}
