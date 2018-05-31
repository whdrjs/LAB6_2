package com.example.jjong.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName,editNumber;
    Button btnLoad,btnSave,btnInit;
    String name,number;
    SharedPreferences spref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.sn2);
        editNumber = findViewById(R.id.sn);

        btnLoad = findViewById(R.id.load);
        btnSave = findViewById(R.id.save);
        btnInit = findViewById(R.id.clear);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                number = editNumber.getText().toString();
                sharedPreferences();
                Toast.makeText(getApplicationContext(),"Save!",Toast.LENGTH_SHORT).show();
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editNumber.setText("");
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
                Toast.makeText(getApplicationContext(),"Load!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void sharedPreferences()
    {
        spref = getSharedPreferences("Login", MODE_PRIVATE);
        toEdit = spref.edit();
        toEdit.putString("Username", name);
        toEdit.putString("ID", number);
        toEdit.commit();
    }
    public void applySharedPreference(){
        spref = getSharedPreferences("Login", MODE_PRIVATE);
        if (spref != null && spref.contains("Username")&& spref.contains("ID")) {
            String sname = spref.getString("Username", "noname");
            String snumber=spref.getString("ID", "noID");
            editName.setText(sname);
            editNumber.setText(snumber);
        }
    }
}
