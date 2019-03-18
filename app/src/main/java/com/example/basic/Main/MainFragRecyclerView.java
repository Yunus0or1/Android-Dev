package com.example.basic.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basic.R;

public class MainFragRecyclerView extends RecyclerView.Adapter<MainFragRecyclerView.ViewHolder>{

    private Context mContext ;
    private String[] stringA ;


    public MainFragRecyclerView(Context mContext,String[] stringA) {

        this.mContext = mContext;
        this.stringA = stringA ;
    }

    @NonNull
    @Override
    public MainFragRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main_recyclerview,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MainFragRecyclerView.ViewHolder viewHolder, int i) {

        viewHolder.number.setText(stringA[i]);

    }

    @Override
    public int getItemCount() {
        return stringA.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView number;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            number = itemView.findViewById(R.id.tvRecycler);

        }
    }
}
