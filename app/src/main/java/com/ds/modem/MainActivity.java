package com.ds.modem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("iDIRECT Modem Virtualization\n\nReady...");
        tv.setTextColor(0xFFFFFFFF);
        tv.setBackgroundColor(0xFF000000);
        tv.setPadding(20,20,20,20);

        setContentView(tv);
    }
}
