package com.app.sample.social.activity_mutiple_image;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.app.sample.social.R;
import com.app.sample.social.adpater_viewpager.MyCustomPagerAdapter;
import com.app.sample.social.mode_product.productImage;
import com.app.sample.social.product_presenter.ListMutipleImageContract;
import com.app.sample.social.product_presenter.ListProductIdContract;
import com.app.sample.social.product_presenter.MutipleImageIdPresenter;
import com.app.sample.social.product_presenter.ProductIdPresenter;

import java.util.ArrayList;

public class ActivityMutipleImage extends AppCompatActivity implements ListMutipleImageContract.HomeViewProduct {

    ViewPager viewPager;

    MyCustomPagerAdapter myCustomPagerAdapter;
    String idProduct;
    ListMutipleImageContract.HomePresenterProduct presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);
        idProduct = getIntent().getStringExtra("idProduct");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        presenter = new MutipleImageIdPresenter(this);
        presenter.getAllImageProduct(idProduct);

    }

    @Override
    public void showAllImageProduct(ArrayList<productImage> feed) {
        myCustomPagerAdapter = new MyCustomPagerAdapter(ActivityMutipleImage.this, feed);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}
