package talzemah.crackme1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mLogInUserNameField;
    private TextView mLogInPasswordField;
    private Button mLogInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogInUserNameField = (TextView) findViewById(R.id.LogInUserNameField);
        mLogInPasswordField = (TextView) findViewById(R.id.LogInPasswordField);

        mLogInBtn = (Button) findViewById(R.id.btnLogIn);
        mLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckAuthentication();
            }
        });
    }

    private void CheckAuthentication() {

        String userName = mLogInUserNameField.getText().toString().trim();
        String password = mLogInPasswordField.getText().toString().trim();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {

            Toast.makeText(MainActivity.this, "Field/s are empty", Toast.LENGTH_SHORT).show();
        }

        else {

            Calendar cal = Calendar.getInstance();

            //24 hour format
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);

            if (password.equals(String.valueOf(hour) + String.valueOf(minute))) {

                Intent SuccessIntent = new Intent(MainActivity.this, SuccessActivity.class);
                startActivity(SuccessIntent);
            }

            else {

                Toast.makeText(MainActivity.this, "Failed, try again"  , Toast.LENGTH_LONG).show();
            }
        }
    }
}
