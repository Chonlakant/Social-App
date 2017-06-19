package com.app.sample.social.product_presenter;

import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.mode_product.productImage;

import java.util.ArrayList;
import java.util.List;

public interface ListMutipleImageContract {
    interface HomeViewProduct {

        void showAllImageProduct(ArrayList<productImage> feed);



    }

    interface HomePresenterProduct {

        void getAllImageProduct(String id);
    }
}
