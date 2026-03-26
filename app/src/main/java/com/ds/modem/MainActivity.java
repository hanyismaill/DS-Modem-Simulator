package com.ds.modem;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText screen;
    StringBuilder buffer = new StringBuilder();

    int stage = 0;
    String username = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        screen = new EditText(this);
        screen.setTextSize(18);
        screen.setPadding(20, 40, 20, 20);
        screen.setInputType(InputType.TYPE_CLASS_TEXT);
        screen.setSingleLine(false);

        screen.setText(
                "iDIRECT Modem Virtualization\n\n" +
                "Ready...\n\n" +
                "Username: "
        );

        setContentView(screen);

        // Force keyboard to open
        screen.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(screen, InputMethodManager.SHOW_IMPLICIT);

        screen.setOnEditorActionListener((v, actionId, event) -> {
            handleInput();
            return true;
        });
    }

    void handleInput() {

        String input = screen.getText().toString().trim();

        if (stage == 0) {
            username = input.substring(input.lastIndexOf("Username:") + 9).trim();

            screen.append("\nPassword: ");
            stage = 1;
        }

        else if (stage == 1) {
            password = input.substring(input.lastIndexOf("Password:") + 9).trim();

            if (username.equals("admin") && password.equals("admin")) {
                screen.append("\n\nAccess Granted\n>");
                stage = 2;
            } else {
                screen.append("\n\nAccess Denied\n\nUsername: ");
                stage = 0;
            }
        }

        else if (stage == 2) {
            screen.append("\nExecuted\n>");
        }
    }
                }
