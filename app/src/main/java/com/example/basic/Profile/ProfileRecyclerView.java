package com.example.basic.Profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basic.R;

import java.util.ArrayList;

public class ProfileRecyclerView extends RecyclerView.Adapter<ProfileRecyclerView.ViewHolder>{

    private Context mContext ;
    ArrayList<String> imgURLs = new ArrayList<>();


    public ProfileRecyclerView(Context mContext,ArrayList<String> imgURLs) {

        this.mContext = mContext;
        this.imgURLs = imgURLs ;
    }

    @NonNull
    @Override
    public ProfileRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_image_recyclerview,viewGroup,false);
        return new ProfileRecyclerView.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRecyclerView.ViewHolder viewHolder, int i) {

        // Now sectionAdapter is the Horizontal RecyclerView
        // So here the total imgURLS ArrayList is passed. And then these are inflated horizontally.
        // In ProfileRecyclerView XML file a new RecyclerView is named so that sectionAdapter can
        // inflate it's items. So in ProfileRecyclerView, the viewHolder finds the item and inflates
        // items of sectionAdapter

        // So this is how Two RecyclerView work together.
        sectionAdapter secAdapter = new sectionAdapter(mContext,imgURLs);

        viewHolder.sectionRecycler.setHasFixedSize(true);
        viewHolder.sectionRecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.sectionRecycler.setAdapter(secAdapter);
    }

    @Override
    public int getItemCount() {
        return imgURLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        RecyclerView sectionRecycler;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.title);
            sectionRecycler = itemView.findViewById(R.id.sectionRecycler);

        }
    }
}
