package rohitsingla.rdrock.databackwardpassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewName, textViewPhone;
    Button buttonGoForward;
    String getDataName, getDataPhone;
    Intent i;
    long backKeyPressedTime;


    void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);
        buttonGoForward = findViewById(R.id.buttonGoForward);
        buttonGoForward.setOnClickListener(this);
        i = new Intent(MainActivity.this, MainActivity2.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 2001) {
            getDataName = data.getStringExtra("keyName");
            getDataPhone = data.getStringExtra("keyPhone");
            textViewName.setText(getDataName);
            textViewPhone.setText(getDataPhone);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonGoForward) {
            startActivityForResult(i, 101);
        }
    }

    @Override
    public void onBackPressed() {
        if (backKeyPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Press again to Exit", Toast.LENGTH_SHORT).show();
        }
        backKeyPressedTime = System.currentTimeMillis();

    }

}
