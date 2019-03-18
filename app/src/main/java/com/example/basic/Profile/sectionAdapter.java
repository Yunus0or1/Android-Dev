package com.example.basic.Profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.basic.R;

import java.util.ArrayList;

public class sectionAdapter extends RecyclerView.Adapter<sectionAdapter.ViewHolder> {



    private Context mContext ;
    ArrayList<String> imgURLs = new ArrayList<>();


    public sectionAdapter(Context mContext,ArrayList<String> imgURLs) {

        this.mContext = mContext;
        this.imgURLs = imgURLs ;
    }

    @NonNull
    @Override
    public sectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.section_adapter_recycler_imagge,viewGroup,false);
        return new sectionAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull sectionAdapter.ViewHolder viewHolder, int i) {

        Glide.with(mContext)
                .asBitmap()
                .load(imgURLs.get(i))
                .into(viewHolder.profile_image);

    }

    public int getItemCount() {
        return imgURLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView profile_image;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.title);
            profile_image = itemView.findViewById(R.id.sectionImageRecycler);

        }
    }
}
