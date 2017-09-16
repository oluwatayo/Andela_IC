package com.example.android.aic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.aic.controller.DetailActivity;
import com.example.android.aic.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by OLUWATAYO on 15/09/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.items = itemArrayList;
        this.context = applicationContext;
    }
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_row_user, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i){
        viewHolder.textViewUser.setText(items.get(i).getLogin());
        viewHolder.github_link.setText(items.get(i).getHtmlUrl());
        Picasso.with(context)
                .load(items.get(i).getAvatarUrl()).placeholder(R.drawable.loading)
                .into(viewHolder.profilePicture);
    }
    @Override
    public int getItemCount(){
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewUser, github_link;
        private ImageView profilePicture;

        public ViewHolder(View view) {
            super(view);
            this.textViewUser = (TextView) view.findViewById(R.id.textViewUser);
            this.github_link = (TextView) view.findViewById(R.id.github_link);
            this.profilePicture = (ImageView) view.findViewById(R.id.profilePicture);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Item clickedDataItem = items.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", items.get(position).getLogin());
                        intent.putExtra("html_url", items.get(position).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(position).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
