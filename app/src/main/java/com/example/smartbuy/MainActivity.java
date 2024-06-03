package com.example.smartbuy;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
//    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SmoothBottomBar bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);
//        imageView = findViewById(R.id.refineImage);


//        Menu menu = bottomNavigationView.getMenu();

//        MenuItem home = menu.findItem(R.id.home);
//        MenuItem shop = menu.findItem(R.id.shop);
//        MenuItem coupons = menu.findItem(R.id.coupons);
//        MenuItem offers = menu.findItem(R.id.offers);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();


        bottomNavigationView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i) {
                    case 0:
                        setFrag(new HomeFragment());
                        return true;
                    case 1:
                        setFrag(new ShopFragment());
                        return true;
                    case 2:
                        setFrag(new CouponFragment());
                        return true;
                    case 3:
                        setFrag(new OfferFragment());
                        return true;
                }
                return false;
            }

            private void setFrag(Fragment fragment) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
            }
        });
    }
}