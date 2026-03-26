package com.ds.modem;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView output;
    EditText input;

    int stage = 0;
    String username = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        output = new TextView(this);
        output.setTextSize(18);
        output.setPadding(20, 40, 20, 20);

        input = new EditText(this);
        input.setHint("Type here...");
        input.setSingleLine(true);

        layout.addView(output);
        layout.addView(input);

        setContentView(layout);

        // Initial text
        output.setText(
                "iDIRECT Modem Virtualization\n\n" +
                "Ready...\n\n" +
                "Username: "
        );

        // Handle Enter key
        input.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN &&
                keyCode == KeyEvent.KEYCODE_ENTER) {

                handleInput(input.getText().toString().trim());
                input.setText(""); // clear input
                return true;
            }
            return false;
        });
    }

    void handleInput(String text) {

        if (stage == 0) {
            username = text;
            output.append(username + "\nPassword: ");
            stage = 1;
        }

        else if (stage == 1) {
            password = text;
            output.append("****\n");

            if (username.equals("admin") && password.equals("admin")) {
                output.append("\nAccess Granted\n>\n");
                stage = 2;
            } else {
                output.append("\nAccess Denied\n\nUsername: ");
                stage = 0;
            }
        }

        else if (stage == 2) {
            output.append("Executed: " + text + "\n>\n");
        }
    }
                            }
