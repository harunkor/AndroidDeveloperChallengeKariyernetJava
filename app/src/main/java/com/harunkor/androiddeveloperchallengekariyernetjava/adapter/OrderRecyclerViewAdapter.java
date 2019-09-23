package com.harunkor.androiddeveloperchallengekariyernetjava.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.android.databinding.library.baseAdapters.BR;
import com.harunkor.androiddeveloperchallengekariyernetjava.R;
import com.harunkor.androiddeveloperchallengekariyernetjava.model.Order;
import com.harunkor.androiddeveloperchallengekariyernetjava.utils.Handler;


import java.util.List;

public class OrderRecyclerViewAdapter  extends  RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder >  {


    List<Order> orderlist;
    private Context context;



    public OrderRecyclerViewAdapter(List<Order> orderlist, Context ctx) {
        this.orderlist = orderlist;
        context = ctx;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.order_item_row, viewGroup, false);

       // binding.setVariable(BR.handler,this);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)  {
        holder.bind(orderlist.get(position));


        final Boolean[] isOpen = {true};

      holder.itemRowBinding.setVariable(BR.handler, new Handler() {
          @Override
          public void onClick(View view) {
              if(isOpen[0]) {
                  orderlist.get(position).setIsVisibility(View.VISIBLE);
                  holder.bind(orderlist.get(position));
                  isOpen[0] =false;
              }else
              {
                  orderlist.get(position).setIsVisibility(View.GONE);
                  holder.bind(orderlist.get(position));
                  isOpen[0] =true;

              }



          }
      });






    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding itemRowBinding;

        public ViewHolder(ViewDataBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;


        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.orderPacket, obj);
            itemRowBinding.executePendingBindings();


        }
    }



}
