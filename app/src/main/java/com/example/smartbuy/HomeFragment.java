package com.example.smartbuy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        RecyclerView storesRecyclerView = view.findViewById(R.id.storesRecyclerView);
        RecyclerView topBuyRecyclerView = view.findViewById(R.id.buysRecyclerView);
        RecyclerView productRecyclerView = view.findViewById(R.id.productRecyclerView);


        // Use a linear layout manager with horizontal orientation
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);

        layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        storesRecyclerView.setLayoutManager(layoutManager2);

        layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        topBuyRecyclerView.setLayoutManager(layoutManager3);


        // Use a linear layout manager
        productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Array of image resource IDs
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.image1,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.image2, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.image3, ScaleTypes.CENTER_CROP));


        ImageSlider imageSlider = view.findViewById(R.id.image_slider);

        imageSlider.setImageList(imageList);

        // Initialize data
        List<CustomItem> categoryList = new ArrayList<>();
        categoryList.add(new CustomItem("Item 1", R.drawable.coupons_icon));
        categoryList.add(new CustomItem("Item 2", R.drawable.home_icons));
        categoryList.add(new CustomItem("Item 3", R.drawable.filter_icon));
        categoryList.add(new CustomItem("Item 4", R.drawable.coupons_icon));
        categoryList.add(new CustomItem("Item 5", R.drawable.home_icons));
        categoryList.add(new CustomItem("Item 6", R.drawable.filter_icon));



        List<CustomItem> storesList = new ArrayList<>();
        storesList.add(new CustomItem("Item 1", R.drawable.coupons_icon));
        storesList.add(new CustomItem("Item 2", R.drawable.home_icons));
        storesList.add(new CustomItem("Item 3", R.drawable.filter_icon));
        storesList.add(new CustomItem("Item 4", R.drawable.coupons_icon));
        storesList.add(new CustomItem("Item 5", R.drawable.home_icons));
        storesList.add(new CustomItem("Item 6", R.drawable.filter_icon));


        List<CustomItem> topBuysList = new ArrayList<>();
        topBuysList.add(new CustomItem("Item 1", R.drawable.coupons_icon));
        topBuysList.add(new CustomItem("Item 2", R.drawable.home_icons));
        topBuysList.add(new CustomItem("Item 3", R.drawable.filter_icon));
        topBuysList.add(new CustomItem("Item 4", R.drawable.coupons_icon));
        topBuysList.add(new CustomItem("Item 5", R.drawable.home_icons));
        topBuysList.add(new CustomItem("Item 6", R.drawable.filter_icon));


        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", "$10", R.drawable.home_icons));
        productList.add(new Product("Product 2", "$20", R.drawable.filter_icon));
        productList.add(new Product("Product 3", "$30", R.drawable.coupons_icon));
        productList.add(new Product("Product 1", "$10", R.drawable.home_icons));
        productList.add(new Product("Product 2", "$20", R.drawable.filter_icon));
        productList.add(new Product("Product 3", "$30", R.drawable.coupons_icon));
        productList.add(new Product("Product 1", "$10", R.drawable.home_icons));
        productList.add(new Product("Product 2", "$20", R.drawable.filter_icon));
        productList.add(new Product("Product 3", "$30", R.drawable.coupons_icon));

        // Specify an adapter
        CategoryAdapter adapter = new CategoryAdapter(categoryList, getContext());
        categoryRecyclerView.setAdapter(adapter);

        CategoryAdapter adapter2 = new CategoryAdapter(storesList, getContext());
        storesRecyclerView.setAdapter(adapter2);

        TopBuysAdapter adapter3 = new TopBuysAdapter(topBuysList, getContext());
        topBuyRecyclerView.setAdapter(adapter3);

        ProductAdapter adapter4 = new ProductAdapter(productList, getContext());
        productRecyclerView.setAdapter(adapter4);


        return view;
    }
}