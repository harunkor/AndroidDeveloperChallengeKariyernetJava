package com.harunkor.androiddeveloperchallengekariyernetjava.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.harunkor.androiddeveloperchallengekariyernetjava.R;
import com.harunkor.androiddeveloperchallengekariyernetjava.databinding.ActivityLoginBinding;
import com.harunkor.androiddeveloperchallengekariyernetjava.model.Login;
import com.harunkor.androiddeveloperchallengekariyernetjava.utils.Handler;

import es.dmoral.prefs.Prefs;

public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding binding;
    private String username;
    private String password;
    private int loginChecked;
    private Intent main;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        main=new Intent(this,MainActivity.class);
        main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        loginChecked=Prefs.with(LoginActivity.this).readInt("LOGIN", 0);
        if(loginChecked==1)
        {
            startActivity(main);


        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);





        binding.setHandler(new Handler() {
            @Override
            public void onClick(View view) {


                if(isRequirement())
                {



                if(isLogin(getApplicationContext()))
                {
                    if(binding.switchButton.isChecked())
                    {
                        Prefs.with(LoginActivity.this).writeInt("LOGIN", 1);

                    }

                    startActivity(main);


                }else
                {
                    Toast.makeText(LoginActivity.this, "kullanıcı adı veya şifre yanlış !", Toast.LENGTH_SHORT).show();
                }


            }
            }
        });








    }

    public Boolean isLogin(Context context)
    {
        username=binding.username.getText().toString().trim();
        password=binding.password.getText().toString().trim();
        String user=context.getString(R.string.username);
        String pass=context.getString(R.string.password);
        if(username.equals(user) && password.equals(pass))
        {

            return  true;

        }else
        {
            return false;
        }



    }

    public Boolean isRequirement()

    {
        username=binding.username.getText().toString().trim();
        password=binding.password.getText().toString().trim();


        if(username.isEmpty() || password.isEmpty())
        {
            binding.username.setHint("* Kullanıcı adınız");
            binding.username.setHintTextColor(Color.RED);
            binding.password.setHint("* Şifreniz");
            binding.password.setHintTextColor(Color.RED);


          return  false;

        }else {
            return true;
        }









    }



}
