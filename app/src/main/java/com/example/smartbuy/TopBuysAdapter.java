package com.example.smartbuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopBuysAdapter extends RecyclerView.Adapter<TopBuysAdapter.ViewHolder> {

    private final List<CustomItem> itemList;

    TopBuysAdapter(List<CustomItem> itemList, Context context) {
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.CardImg);
            textView = view.findViewById(R.id.CardText);
        }
    }

    @NonNull
    @Override
    public TopBuysAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topbuy_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomItem item = itemList.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getImageResourceId());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
