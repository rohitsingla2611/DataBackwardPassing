package rohitsingla.rdrock.databackwardpassing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText editTextName, editTextPhone;
    Button buttonGoBack;
    String StrName, StrPhone;
    Intent intent;
    long backKeyPressedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }


    void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonGoBack = findViewById(R.id.buttonGoBack);
        intent = new Intent();
        getSupportActionBar().setTitle("ACTIVITY TWO");
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.buttonGoBack) {
                    onBackPressed();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        StrName = editTextName.getText().toString().trim();
        StrPhone = editTextPhone.getText().toString().trim();
        if ((TextUtils.isEmpty(StrName)) || (TextUtils.isEmpty(StrPhone))) {

            if ((TextUtils.isEmpty(StrName)) && (TextUtils.isEmpty(StrPhone))) {
                Toast.makeText(this, "Please Enter Your Details", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(StrName)) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please Enter Your Phone", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, " " + StrName + " " + StrPhone, Toast.LENGTH_LONG).show();
            intent.putExtra("keyName", StrName);
            intent.putExtra("keyPhone", StrPhone);
            setResult(2001, intent);
            finish();
            if (backKeyPressedTime == System.currentTimeMillis()) {
                super.onBackPressed();
            }
        }
    }
}

