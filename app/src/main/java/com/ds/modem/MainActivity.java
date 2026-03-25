package com.ds.modem;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    int stage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        screen = new TextView(this);
        screen.setTextColor(0xFFFFFFFF);
        screen.setBackgroundColor(0xFF000000);
        screen.setTextSize(16);
        screen.setPadding(20, 40, 20, 20);

        setContentView(screen);

        startCLI();
    }

    private void startCLI() {
        if (stage == 0) {
            screen.setText("Username: admin\nPassword: ");
            stage = 1;
        } else if (stage == 1) {
            screen.append("\n\n[RMT:17231] admin@telnet:127.0.0.1;4494\n");
        }
    }
}
