package com.app.sample.social.articles_presenter;

import com.app.sample.social.mode_product.product;
import com.app.sample.social.model_articles.ArticlesList;

import java.util.List;

public interface ListArticlesContract {
    interface HomeViewArticles {
        void showLoading();

        void hideLoading();

        void showAllArticles(List<ArticlesList> products);



    }

    interface HomePresenterArticles {
        void getAllArticles(String id);
    }
}
