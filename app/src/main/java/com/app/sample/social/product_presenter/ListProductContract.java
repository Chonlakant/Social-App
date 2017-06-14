package com.app.sample.social.product_presenter;

import com.app.sample.social.mode_product.product;
import com.app.sample.social.model.Friend2;

import java.util.List;

public interface ListProductContract {
    interface HomeViewProduct {
        void showLoading();

        void hideLoading();

        void showAllProduct(List<product> products);



    }

    interface HomePresenterProduct {
        void getAllProduct(String id);
    }
}
