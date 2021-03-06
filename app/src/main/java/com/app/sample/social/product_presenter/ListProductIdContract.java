package com.app.sample.social.product_presenter;

import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.mode_product.productImage;

import java.util.ArrayList;
import java.util.List;

public interface ListProductIdContract {
    interface HomeViewProduct {
        void showLoading();

        void hideLoading();

        void showAllProduct(List<productDetails> feed);
        void showAllImageProduct(ArrayList<productImage> feed);



    }

    interface HomePresenterProduct {
        void getAllProduct(String id);
        void getAllImageProduct(String id);
    }
}
