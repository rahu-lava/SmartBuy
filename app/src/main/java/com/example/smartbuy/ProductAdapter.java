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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public ImageView buyImage;

        public ViewHolder(View view) {
            super(view);
            productImage = view.findViewById(R.id.CardImg);
            productName = view.findViewById(R.id.CardText);
            productPrice = view.findViewById(R.id.CardPrice);
            buyImage = view.findViewById(R.id.buyImage);
        }
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(product.getImageResId());
        holder.buyImage.setImageResource(R.drawable.shop_icons);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
