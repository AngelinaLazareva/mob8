package com.example.myapplication5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;


import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

public class SecondFragment extends Fragment {
    final int PERMISSION_REQUEST_CODE = 12;
    final String CHANNEL_ID = "234";
    Button button;

    TextView second_fragment_text_view;
    public SecondFragment() {
        super(R.layout.fragment_second);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        second_fragment_text_view = getActivity().findViewById(R.id.fragment_second_text_view2);
        button = getActivity().findViewById(R.id.fragment_second_button1);

        Bundle bundle = this.getArguments();
        ArrayList<String> message = bundle.getStringArrayList("prodNameAmount");
        String product_name = FirstFragment.parseInputsProducts(message, products.PRODUCT_NAME);
        String product_amount = FirstFragment.parseInputsProducts(message, products.PRODUCT_AMOUNT);
        String result = product_amount + " " + product_name;
        second_fragment_text_view.setText(result);

        Context context = getContext();

        NotificationManager notificationManager =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "GoodsChannel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Channel for goods notification");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);
        }

        if (ContextCompat.checkSelfPermission(context,
                android.Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String contentText = "Result: " + result;

                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(context, CHANNEL_ID)
                                    .setSmallIcon(R.mipmap.ic_launcher)
                                    .setContentTitle("Purchased goods")
                                    .setContentText(contentText);

                    Notification notification = builder.build();
                    notificationManager.notify(1, notification);
                }
            });
        } else {
            requestPermissions();
        }
    }

    public void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] {
                            Manifest.permission.POST_NOTIFICATIONS
                    },
                    PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE &&
                grantResults.length == 1) {
            if (
                    grantResults[0] != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(getContext(), "No permission", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults
        );
    }



}