package com.example.kukluxnet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText roomIdInput;
    private Button generateButton;
    private Button connectButton;
    private String roomId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomIdInput = findViewById(R.id.roomIdInput);
        generateButton = findViewById(R.id.generateButton);
        connectButton = findViewById(R.id.connectButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomId = UUID.randomUUID().toString();
                roomIdInput.setText(roomId);
                generateButton.setText("Копировать");
                connectButton.setEnabled(true);
            }
        });

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomId != null) {
                    Intent intent = new Intent(
                            MainActivity.this, RoomActivity.class
                    );
                    intent.putExtra("ROOM_ID", roomId);
                    startActivity(intent);
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Сначала сгенерируйте ID комнаты",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}