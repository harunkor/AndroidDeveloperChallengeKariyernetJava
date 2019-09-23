package com.harunkor.androiddeveloperchallengekariyernetjava.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;

import com.harunkor.androiddeveloperchallengekariyernetjava.model.Order;
import com.harunkor.androiddeveloperchallengekariyernetjava.service.ApiLoginClient;
import com.harunkor.androiddeveloperchallengekariyernetjava.service.ApiRetroInterface;
import com.harunkor.androiddeveloperchallengekariyernetjava.utils.OnTaskCompleted;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderViewModel extends BaseObservable {


    private Context context;
    private ApiRetroInterface apiRetroInterface;
    private List<Order> orderResources;
    private OnTaskCompleted onTaskCompleted;




    public  OrderViewModel(Context context,OnTaskCompleted onTaskCompleted)
    {
        this.context=context;
        this.onTaskCompleted=onTaskCompleted;





        apiRetroInterface= ApiLoginClient.ClientLogin().create(ApiRetroInterface.class);
        Call<List<Order>> call = apiRetroInterface.OrdersAll();
        call.enqueue(new Callback< List<Order>>() {
            @Override
            public void onResponse(Call< List<Order>> call, Response< List<Order>> response) {

                orderResources=response.body();


                setList(orderResources);




                onTaskCompleted.OnTaskCompleted();


            }

            @Override
            public void onFailure(Call< List<Order>> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG",""+t.getMessage());

                call.cancel();


                onTaskCompleted.OnTaskCompleted();


            }
        });



    }



    @Bindable
    public  List<Order> getList()
    {
        return  orderResources;


    }


    @Bindable
    public void setList( List<Order> orderResources)
    {
        this.orderResources=orderResources;




    }









}
