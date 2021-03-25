package com.arpbtxrebon.barantum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button btn_signup;
    TextView textViewSignIn;
    EditText et_signUp_nama, et_signup_email,et_signup_pw,et_signUp_pw_re;
    ConstraintLayout layout_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        btn_signup = findViewById(R.id.btnSignUp);
        et_signUp_nama = findViewById(R.id.et_signup_nama);
        et_signup_email = findViewById(R.id.et_signup_email);
        et_signup_pw = findViewById(R.id.et_signup_pw);
        et_signUp_pw_re = findViewById(R.id.et_signup_pw_re);
        layout_signup = findViewById(R.id.Layout_signout);
        layout_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_signUp_nama.getText().toString().equals("") || (et_signup_pw.getText().toString().equals(""))||(et_signUp_pw_re.getText().toString().equals(""))) {
                    Toast.makeText(SignUp.this, "User atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (cekUser(et_signUp_nama.getText().toString())) {
                    Toast.makeText(SignUp.this, "User name Telah di gunakan", Toast.LENGTH_SHORT).show();
                } else if (!et_signup_pw.getText().toString().equals(et_signUp_pw_re.getText().toString())) {
                    Toast.makeText(SignUp.this, "Pasword Tidak Sama", Toast.LENGTH_SHORT).show();
                } else {
                    Preferences.setRegisteredUser(getBaseContext(),et_signUp_nama.getText().toString());
                    Preferences.setRegisteredPass(getBaseContext(),et_signup_pw.getText().toString());
                    finish();
                    Toast.makeText(SignUp.this, "User Telah Berhasil Di buat silahkan Login kembali", Toast.LENGTH_LONG).show();

                }
            }
        });


        textViewSignIn = findViewById(R.id.textSignIn);
                textViewSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SignUp.this,SignIn.class));
                        finishAffinity();
                    }
                });
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(

                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        }
    }
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}