package com.ds.modem;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    EditText input;
    int stage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        screen = new TextView(this);
        screen.setText("iDIRECT Modem Virtualization\n\nReady...\n\nUsername:");

        input = new EditText(this);
        input.setHint("Enter username");

        layout.addView(screen);
        layout.addView(input);

        setContentView(layout);

        // ENTER key listener (FIXED)
        input.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_ENTER) {

                handleInput();
                return true;
            }
            return false;
        });
    }

    private void handleInput() {
        String text = input.getText().toString();

        if (stage == 0) {
            screen.append("\n" + text + "\nPassword:");
            input.setText("");
            stage = 1;

        } else if (stage == 1) {
            screen.append("\n****\n\nAccess Granted\n> ");
            input.setText("");
            stage = 2;
        }
    }
}
