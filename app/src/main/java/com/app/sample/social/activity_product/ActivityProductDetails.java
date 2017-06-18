package com.app.sample.social.activity_product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.app.sample.social.R;
import com.app.sample.social.adapter.ProductDetailsImageListAdapter;
import com.app.sample.social.adapter.ProductDetailsListAdapter;
import com.app.sample.social.data.Tools;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.mode_product.productImage;
import com.app.sample.social.product_presenter.ListProductIdContract;
import com.app.sample.social.product_presenter.ProductIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityProductDetails extends AppCompatActivity implements ListProductIdContract.HomeViewProduct {

    public static String KEY_FRIEND = "com.app.sample.social.FRIEND";
    public static String KEY_SNIPPET = "com.app.sample.social.SNIPPET";

    ListProductIdContract.HomePresenterProduct presenter;

    public EditText edit_text_comment;
    public static ProductDetailsListAdapter adapter;
    private ProductDetailsImageListAdapter productDetailsImageListAdapter;

    private RecyclerView recyclerViewDetails;
    private RecyclerView recyclerViewImage;
    private ActionBar actionBar;
    private product friend;
    private List<product> items = new ArrayList<>();
    private View parent_view;

    String idProduct;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        parent_view = findViewById(android.R.id.content);
        edit_text_comment = (EditText) findViewById(R.id.edit_text_comment);

        recyclerViewDetails = (RecyclerView) findViewById(R.id.recyclerViewDetails);
        recyclerViewDetails.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewDetails.setHasFixedSize(true);

        recyclerViewImage = (RecyclerView) findViewById(R.id.recyclerViewImage);

        mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false
        );
        recyclerViewImage.setLayoutManager(mLayoutManager);

        // animation transition
        ViewCompat.setTransitionName(parent_view, KEY_FRIEND);

        // initialize conversation data
        Intent intent = getIntent();
        friend = (product) intent.getExtras().getSerializable(KEY_FRIEND);
        String snippets = intent.getStringExtra(KEY_SNIPPET);
        initToolbar();

        idProduct = getIntent().getStringExtra("id_product");

        presenter = new ProductIdPresenter(this);
        presenter.getAllProduct(idProduct);
        presenter.getAllImageProduct(idProduct);


        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle(friend.getHtml().get(0).getName());
    }



    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private TextWatcher contentWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable etd) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_details, menu);
        return true;
    }

    /**
     * Handle click on action bar
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_sample:
                Snackbar.make(parent_view, item.getTitle() + " Clicked ", Snackbar.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showAllProduct(List<productDetails> feed) {
        adapter = new ProductDetailsListAdapter(this, feed);
        recyclerViewDetails.setAdapter(adapter);
    }

    @Override
    public void showAllImageProduct(ArrayList<productImage> feed) {
        productDetailsImageListAdapter = new ProductDetailsImageListAdapter(this, feed);
        recyclerViewImage.setAdapter(productDetailsImageListAdapter);
    }

}
