package com.harunkor.androiddeveloperchallengekariyernetjava.view;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.harunkor.androiddeveloperchallengekariyernetjava.R;
import com.harunkor.androiddeveloperchallengekariyernetjava.adapter.OrderRecyclerViewAdapter;
import com.harunkor.androiddeveloperchallengekariyernetjava.model.Login;
import com.harunkor.androiddeveloperchallengekariyernetjava.utils.Handler;
import com.harunkor.androiddeveloperchallengekariyernetjava.utils.OnTaskCompleted;
import com.harunkor.androiddeveloperchallengekariyernetjava.viewmodel.OrderViewModel;
import com.harunkor.androiddeveloperchallengekariyernetjava.databinding.ActivityMainBinding;

import es.dmoral.prefs.Prefs;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                    RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
            tv.setLayoutParams(lp);
            tv.setText(bar.getTitle());
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }


        orderViewModel= new OrderViewModel(this, new OnTaskCompleted() {
            @Override
            public void OnTaskCompleted() {
                OrderRecyclerViewAdapter orderRecyclerViewAdapter= new OrderRecyclerViewAdapter(orderViewModel.getList(),MainActivity.this);
                binding.setOrderAdapter(orderRecyclerViewAdapter);








            }
        });



        binding.setHandler(new Handler() {
            @Override
            public void onClick(View view) {
                Prefs.with(MainActivity.this).writeInt("LOGIN", 0);
                Intent login=new Intent(MainActivity.this, LoginActivity.class);
                login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(login);
            }
        });










    }
}
