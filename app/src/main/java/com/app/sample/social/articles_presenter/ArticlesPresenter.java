package com.app.sample.social.articles_presenter;


import com.app.sample.social.api.ApisZaab;
import com.app.sample.social.model_articles.ArticlesList;
import com.app.sample.social.service.ServiceApiZaab;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesPresenter implements ListArticlesContract.HomePresenterArticles {
    private ListArticlesContract.HomeViewArticles viewUser;
    private ServiceApiZaab serviceApiZaab;
    ArrayList<ArticlesList> list = new ArrayList<>();


    public ArticlesPresenter(ListArticlesContract.HomeViewArticles viewUser) {
        this.viewUser = viewUser;
        serviceApiZaab = ApisZaab.getApis();
    }


    @Override
    public void getAllArticles(String id) {

        viewUser.showLoading();


        serviceApiZaab.getArticles().enqueue(new Callback<ArticlesList>() {
            @Override
            public void onResponse(Call<ArticlesList> call, Response<ArticlesList> response) {
                for (int i = 0; i < response.body().getHtml().size(); i++) {
                    list.add(response.body());
                }

                viewUser.showAllArticles(list);

                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<ArticlesList> call, Throwable t) {

            }
        });

    }
}
