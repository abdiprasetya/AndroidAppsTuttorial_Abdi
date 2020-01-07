package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Nama;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nama=(EditText)findViewById(R.id.etNama);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);

        Info.setText("Nomor Kesalahan Memasukan Password: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Nama.getText().toString(), Password.getText().toString());
            }
        });

}

    private void validate(String userNama, String userPassword){
        if((userNama == "Admin") && (userPassword == "1234")){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Nomor Kesalahan Memasukan Password: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
