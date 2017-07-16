package com.app.sample.social.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.ActivitySelectFriend;
import com.app.sample.social.R;
import com.app.sample.social.activity_product.ActivityPostPostduct;
import com.app.sample.social.activity_product.ActivityProductDetails;
import com.app.sample.social.adapter.ProductDetailsImageListAdapter;
import com.app.sample.social.adapter.ProductListAdapter;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.product_presenter.ListProductContract;
import com.app.sample.social.product_presenter.ProductPresenter;

import java.util.List;

public class PageProductFragment extends Fragment implements ListProductContract.HomeViewProduct {

    private RecyclerView recyclerView;
    private ProductListAdapter mAdapter;
    private View view;
    private SearchView search;

    ListProductContract.HomePresenterProduct presenter;

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_message, container, false);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);

        // activate fragment menu
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);

        presenter = new ProductPresenter(this);
        presenter.getAllProduct("");
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_message, menu);
        search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setIconified(false);
        search.setQueryHint("Search Message...");
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                try {
                    mAdapter.getFilter().filter(s);
                } catch (Exception e) {

                }
                return true;
            }
        });
        search.onActionViewCollapsed();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_message:
                Intent i = new Intent(getActivity(), ActivitySelectFriend.class);
                startActivity(i);
                return true;

            case R.id.action_post_product:

                Intent intent = new Intent(getActivity(), ActivityPostPostduct.class);
                startActivity(intent);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showAllProduct(final List<product> product) {
        mAdapter = new ProductListAdapter(getActivity(), product);
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(new ProductListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, product obj, int position) {
                String id = product.get(position).getHtml().get(position).getId();
                Intent i = new Intent(getActivity(), ActivityProductDetails.class);
                i.putExtra("id_product", id);
                startActivity(i);
            }
        });
    }
}
