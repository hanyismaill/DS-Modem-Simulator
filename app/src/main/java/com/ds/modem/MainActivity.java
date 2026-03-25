import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView terminal;

    String buffer = "";
    String username = "";
    String password = "";

    int stage = 0; // 0=username, 1=password, 2=CLI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        terminal = new TextView(this);
        terminal.setTextColor(0xFFFFFFFF);
        terminal.setBackgroundColor(0xFF000000);
        terminal.setTextSize(14);
        terminal.setPadding(20,20,20,20);

        setContentView(terminal);

        print("Username: ");
    }

    void print(String s) {
        terminal.append(s);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        char c = (char) event.getUnicodeChar();

        if (keyCode == KeyEvent.KEYCODE_ENTER) {

            if (stage == 0) {
                username = buffer;
                buffer = "";
                print("\nPassword: ");
                stage = 1;
            }
            else if (stage == 1) {
