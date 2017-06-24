package com.app.sample.social.presenter_login;

import com.app.sample.social.model.Login;

import java.util.List;

public interface LoginUserContract {
    interface HomeViewLoginUsers {


        void loginUser(List<Login> login);


    }

    interface HomePresenterLogoinUser {
        void loginUser(String email,String pass,String time);

    }
}
